package com.johnson.kevin.exceptions.spotify;

/**
 * Indicates Spotify album could not be retrieved
 */
public class SpotifyAlbumRequestException extends Exception {
    /**
     * Constructs a new exception with a default message and a causing exception.
     * @param cause original exception thrown
     */
    public SpotifyAlbumRequestException(Throwable cause) {
        super("Failed to retrieve Spotify Album", cause);
    }
}