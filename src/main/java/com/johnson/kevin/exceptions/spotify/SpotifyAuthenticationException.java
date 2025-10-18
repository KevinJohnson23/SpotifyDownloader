package com.johnson.kevin.exceptions.spotify;

/**
 * Indicates access token could not be retrieved for provided Spotify client credentials
 */
public class SpotifyAuthenticationException extends Exception {
    /**
     * Constructs a new exception with a default message and a causing exception.
     * @param cause original exception thrown
     */
    public SpotifyAuthenticationException(Throwable cause) {
        super("Failed to authenticate with Spotify", cause);
    }
}