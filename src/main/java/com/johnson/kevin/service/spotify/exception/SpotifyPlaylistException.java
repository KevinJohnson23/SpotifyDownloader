package com.johnson.kevin.service.spotify.exception;

/**
 * Indicates something went wrong when trying to load playlist
 */
public class SpotifyPlaylistException extends Exception {
    /**
     * Constructs a new exception with a default message and a causing exception.
     * @param cause original exception thrown
     */
    public SpotifyPlaylistException(Throwable cause) {
        super("Failed to load playlist", cause);
    }
}