package com.johnson.kevin.service;

import com.johnson.kevin.model.PlaylistEntity;
import com.johnson.kevin.model.SongEntity;
import com.johnson.kevin.service.youtube.YouTubeDownloader;
import com.johnson.kevin.service.youtube.exception.YouTubeDownloadException;
import com.johnson.kevin.service.youtube.util.YouTubeFormCommand;
import com.johnson.kevin.service.youtube.util.YouTubeParseList;

import java.io.IOException;
import java.util.List;

/**
 * A service to download the songs in a {@link PlaylistEntity}
 */
public class YouTubeDownloadService {

    /**
     * Download a playlist of songs from YouTube.
     * @param playlist the playlist to download
     * @param path the path to store the playlist
     * @throws YouTubeDownloadException if failed to download songs
     */
    public static void downloadPlaylist(PlaylistEntity playlist, String path)
        throws YouTubeDownloadException
    {
        List<String> ids = playlist.stream()
            .map(SongEntity::getId)
            .toList();
        List<String> queries = playlist.stream()
            .map(SongEntity::toString)
            .toList();
        List<String> durations = playlist.stream()
            .map(song -> (song.getDurationMs() / 1000))
            .map(Object::toString)
            .toList();
        List<String> command = YouTubeFormCommand.formCommand(
            YouTubeParseList.parseList(ids),
            YouTubeParseList.parseList(queries),
            YouTubeParseList.parseList(durations),
            path + "/" + playlist.getName()
        );
        try {
            YouTubeDownloader.runProcess(command);
        } catch (InterruptedException | IOException e) {
            throw new YouTubeDownloadException(e);
        }
    }
}