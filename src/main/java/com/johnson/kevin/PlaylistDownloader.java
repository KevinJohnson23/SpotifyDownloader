package com.johnson.kevin;

import com.johnson.kevin.model.PlaylistEntity;
import com.johnson.kevin.service.SpotifyPlaylistService;
import com.johnson.kevin.service.YouTubeDownloadService;
import com.johnson.kevin.service.spotify.exception.SpotifyPlaylistException;
import com.johnson.kevin.service.youtube.exception.YouTubeDownloadException;

/**
 * Create a new folder containing songs from a Spotify playlist.
 */
public class PlaylistDownloader {

    /**
     * Download playlist at given path.
     * @param playlistUrl URL of playlist on Spotify
     * @param path path to create playlist folder
     */
    public static void downloadPlaylist(String playlistUrl, String path)
        throws SpotifyPlaylistException, YouTubeDownloadException
    {
        PlaylistEntity playlist = SpotifyPlaylistService.getPlaylist(playlistUrl);
        YouTubeDownloadService.downloadPlaylist(playlist, path);
    }
}
