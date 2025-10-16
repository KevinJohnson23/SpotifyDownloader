package com.johnson.kevin.exceptions;

/**
 * Indicates an incorrect Spotify playlist URI was given.
 */
public class InvalidPlaylistUriException extends Exception {
    /**
     * Constructs a new exception with a default message.
      */
    public InvalidPlaylistUriException() {
        super("Invalid Spotify playlist URI");
    }
}
