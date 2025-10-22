package com.johnson.kevin.integration;

import com.johnson.kevin.model.ArtistEntity;
import com.johnson.kevin.model.EntityMultivalue;
import com.johnson.kevin.model.PlaylistEntity;
import com.johnson.kevin.model.SongEntity;
import com.johnson.kevin.service.YouTubeDownloadService;
import com.johnson.kevin.service.youtube.exception.YouTubeDownloadException;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Integration test for YoutubeDownloader.
 */
public class YoutubeDownloaderIT {

    private static final String outputPath = "target/downloads";

    /**
     * Helper to remove output folder before testing again
     */
    private void removeOutputFolder() {
        File outputFolder = new File(outputPath);
        String[] entries = outputFolder.list();
        if (entries != null) {
            for (String s : entries) {
                File file = new File(outputFolder.getPath(), s);
                file.delete();
            }
        }
        outputFolder.delete();
    }

    /**
     * Helper to get number of files in output folder
     * @param path path to search
     */
    private int getNumFiles(String path) {
        File outputFolder = new File(path);
        String[] entries = outputFolder.list();
        return entries != null ? entries.length : 0;
    }

    @Test
    public void emptyPlaylistShouldDownloadNothing() throws YouTubeDownloadException {
        removeOutputFolder();
        PlaylistEntity playlist = new PlaylistEntity();
        YouTubeDownloadService.downloadPlaylist(playlist, outputPath);
        assertEquals(getNumFiles(outputPath + "/" + playlist.getName()), 0);
    }

    @Test
    public void filledPlaylistShouldDownloadMany() throws YouTubeDownloadException {
        removeOutputFolder();
        PlaylistEntity playlist = new PlaylistEntity(null, "test_name", null);

        EntityMultivalue<ArtistEntity> artists1 = new EntityMultivalue<>();
        artists1.add(new ArtistEntity(null, "Soundgarden", null, null));
        SongEntity song1 = new SongEntity("1", "Black Hole Sun", null, artists1, 321000);
        playlist.add(song1);

        EntityMultivalue<ArtistEntity> artists2 = new EntityMultivalue<>();
        artists2.add(new ArtistEntity(null, "Nirvana", null, null));
        SongEntity song2 = new SongEntity("2", "Negative Creep", null, artists2, 162000);
        playlist.add(song2);

        EntityMultivalue<ArtistEntity> artists3 = new EntityMultivalue<>();
        artists3.add(new ArtistEntity(null, "Alice in Chains", null, null));
        SongEntity song3 = new SongEntity("3", "Man in the Box", null, artists3, 272000);
        playlist.add(song3);

        YouTubeDownloadService.downloadPlaylist(playlist, outputPath);
        assertEquals(3, getNumFiles(outputPath + "/" + playlist.getName()));
    }
}
