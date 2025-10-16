package com.johnson.kevin.service;

import com.johnson.kevin.exceptions.InvalidPlaylistUriException;
import com.johnson.kevin.model.Playlist;
import io.github.cdimascio.dotenv.Dotenv;

/**
 * Service to get information from Spotify.
 */
public class SpotifyService {

    public static Playlist loadPlaylist(String uri) throws InvalidPlaylistUriException {
        return new Playlist("name", uri);
    }
}
