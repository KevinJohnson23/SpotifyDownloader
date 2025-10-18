package com.johnson.kevin;

import com.johnson.kevin.model.PlaylistEntity;
import com.johnson.kevin.service.SpotifyPlaylistService;
import com.johnson.kevin.service.spotify.exception.SpotifyPlaylistException;
import com.johnson.kevin.service.youtube.YouTubeDownloader;
import com.johnson.kevin.service.youtube.exception.YouTubeDownloadException;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * CLI app to download playlist by Spotify URL into specific path
 */
public class Main {
    /**
     * Entry point of application.
     * @param args Command-line arguments. Expected:
     *              <ul>
     *                  <li><code>--playlistUrl &lt;URL&gt;</code>: URL of playlist on Spotify</li>
     *                  <li><code>--path &lt;directory&gt;</code>: Path to open in file explorer</li>
     *              </ul>
     */
    public static void main(String[] args) {
        String playlistUrl = args[0];
        String path = args[1];
        if (playlistUrl == null) {
            System.out.println("Please provide a playlist URL.");
            return;
        }
        PlaylistEntity playlist;
        try {
            playlist = SpotifyPlaylistService.getPlaylist(playlistUrl);
        } catch (SpotifyPlaylistException e) {
            System.out.println("Failed to load playlist from Spotify.");
            System.out.println(e.getMessage());
            return;
        }
        try {
            YouTubeDownloader.downloadPlaylist(playlist, path);
        } catch (YouTubeDownloadException e) {
            System.out.println("Failed to download playlist from YouTube.");
            System.out.println(e.getMessage());
            return;
        }
        try {
            Desktop.getDesktop().open(new File(path));
        } catch (IOException e) {
            System.out.println("Failed to open file explorer at path '" + path + "'.");
            System.out.println(e.getMessage());
        }
    }
}
