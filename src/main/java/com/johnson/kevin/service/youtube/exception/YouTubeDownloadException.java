package com.johnson.kevin.service.youtube.exception;

/**
 * Indicates YouTube song couldn't be downloaded
 */
public class YouTubeDownloadException extends Exception {
    /**
     * Constructs a new exception with a default message and a causing exception.
     * @param cause original exception thrown
     */
    public YouTubeDownloadException(Throwable cause) {
        super("Failed to download from YouTube", cause);
    }
}