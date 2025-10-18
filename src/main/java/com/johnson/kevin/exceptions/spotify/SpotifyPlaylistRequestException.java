package com.johnson.kevin.exceptions.spotify;

/**
 * Indicates Spotify playlist could not be retrieved
 */
public class SpotifyPlaylistRequestException extends Exception {
    /**
     * Constructs a new exception with a default message and a causing exception.
     * @param cause original exception thrown
     */
    public SpotifyPlaylistRequestException(Throwable cause) {
        super("Failed to retrieve Spotify Playlist", cause);
    }
}