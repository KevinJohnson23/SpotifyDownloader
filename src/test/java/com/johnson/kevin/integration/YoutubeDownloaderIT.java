package com.johnson.kevin.integration;

import com.johnson.kevin.model.ArtistEntity;
import com.johnson.kevin.model.EntityMultivalue;
import com.johnson.kevin.model.PlaylistEntity;
import com.johnson.kevin.model.SongEntity;
import com.johnson.kevin.service.youtube.YouTubeDownloader;
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
     * @throws YouTubeDownloadException
     */
    private int getNumFiles() {
        File outputFolder = new File(outputPath);
        String[] entries = outputFolder.list();
        return entries != null ? entries.length : 0;
    }

    @Test
    public void emptyPlaylistShouldDownloadNothing() throws YouTubeDownloadException {
        removeOutputFolder();
        PlaylistEntity playlist = new PlaylistEntity();
        YouTubeDownloader.downloadPlaylist(playlist, outputPath);
        assertEquals(getNumFiles(), 0);
    }

    @Test
    public void filledPlaylistShouldDownloadMany() throws YouTubeDownloadException {
        removeOutputFolder();
        PlaylistEntity playlist = new PlaylistEntity();

        EntityMultivalue<ArtistEntity> artists1 = new EntityMultivalue<>();
        artists1.add(new ArtistEntity(null, "Soundgarden", null, null));
        SongEntity song1 = new SongEntity(null, "Black Hole Sun", null, artists1, 321000);
        playlist.add(song1);

        EntityMultivalue<ArtistEntity> artists2 = new EntityMultivalue<>();
        artists2.add(new ArtistEntity(null, "Nirvana", null, null));
        SongEntity song2 = new SongEntity(null, "Negative Creep", null, artists2, 162000);
        playlist.add(song2);

        EntityMultivalue<ArtistEntity> artists3 = new EntityMultivalue<>();
        artists3.add(new ArtistEntity(null, "Alice in Chains", null, null));
        SongEntity song3 = new SongEntity(null, "Man in the Box", null, artists3, 272000);
        playlist.add(song3);

        YouTubeDownloader.downloadPlaylist(playlist, outputPath);
        assertEquals(getNumFiles(), 3);
    }
}
