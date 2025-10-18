package com.johnson.kevin.service.spotify.exception;

/**
 * Indicates an incorrect Spotify playlist URL was given.
 */
public class SpotifyPlaylistUrlException extends Exception {
    /**
     * Constructs a new exception with a default message.
     */
    public SpotifyPlaylistUrlException() {
        super("Invalid Spotify playlist URL");
    }
}
