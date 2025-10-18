package com.johnson.kevin.exceptions.spotify;

/**
 * Indicates Spotify artist could not be retrieved
 */
public class SpotifyArtistRequestException extends Exception {
    /**
     * Constructs a new exception with a default message and a causing exception.
     * @param cause original exception thrown
     */
    public SpotifyArtistRequestException(Throwable cause) {
        super("Failed to retrieve Spotify Artist", cause);
    }
}