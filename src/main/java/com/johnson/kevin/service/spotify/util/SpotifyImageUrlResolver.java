package com.johnson.kevin.service.spotify.util;

import se.michaelthelin.spotify.model_objects.specification.Image;

/**
 * Utility to get the image from a Spotify item.
 */
public class SpotifyImageUrlResolver {

    /**
     * Get the URL of a Spotify item's image.
     * @param images Array of Spotify images
     * @return URL of first image if one exists
     */
    public static String getImageUrl(Image[] images) {
        if (images == null) {
            return null;
        }
        if (images.length == 0) {
            return null;
        }
        return images[0].getUrl();
    }
}
