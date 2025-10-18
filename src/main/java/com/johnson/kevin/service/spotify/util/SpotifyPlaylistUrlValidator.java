package com.johnson.kevin.service.spotify.util;

import com.johnson.kevin.service.spotify.exception.SpotifyPlaylistUrlException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility to validate a Spotify playlist URL.
 */
public class SpotifyPlaylistUrlValidator {
    private static final Pattern PLAYLIST_URL_PATTERN =
            Pattern.compile("^https://open\\.spotify\\.com/playlist/([a-zA-Z0-9]+)");

    /**
     * Get the playlist ID from a Spotify playlist URL.
     * @param url URL of the Spotify playlist
     * @return ID of the playlist
     * @throws SpotifyPlaylistUrlException if the URL is invalid
     */
    public static String getId(String url) throws SpotifyPlaylistUrlException {
        if (url == null) {
            throw new SpotifyPlaylistUrlException();
        }
        Matcher matcher = PLAYLIST_URL_PATTERN.matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new SpotifyPlaylistUrlException();
    }
}