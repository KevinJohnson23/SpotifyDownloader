package com.johnson.kevin.exceptions.spotify;

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