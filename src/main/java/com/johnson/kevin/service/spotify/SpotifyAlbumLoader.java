package com.johnson.kevin.service.spotify;

import com.johnson.kevin.service.spotify.exception.SpotifyAlbumRequestException;
import com.johnson.kevin.service.spotify.exception.SpotifyAuthenticationException;
import com.johnson.kevin.model.AlbumEntity;
import com.johnson.kevin.service.spotify.converters.SpotifyAlbumEntityConverter;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumRequest;

import java.io.IOException;

/**
 * A service to request information about a Spotify album.
 */
public class SpotifyAlbumLoader {

    /**
     * Retrieve information about a Spotify artist.
     * @param albumId the ID of the album on Spotify
     * @return album data parsed into a {@link AlbumEntity}
     * @throws SpotifyAlbumRequestException if failed to retrieve album data
     */
    public static AlbumEntity loadAlbum(String albumId)
        throws SpotifyAlbumRequestException
    {
        SpotifyApi api;
        try {
            api = SpotifyApiManager.getApi();
        } catch (SpotifyAuthenticationException e) {
            throw new SpotifyAlbumRequestException(e);
        }
        GetAlbumRequest getAlbumRequest = api
            .getAlbum(albumId)
            .build();
        try {
            Album album = getAlbumRequest.execute();
            return SpotifyAlbumEntityConverter.toAlbumEntity(album);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new SpotifyAlbumRequestException(e);
        }
    }
}
