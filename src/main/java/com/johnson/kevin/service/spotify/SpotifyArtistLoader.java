package com.johnson.kevin.service.spotify;

import com.johnson.kevin.service.spotify.exception.SpotifyArtistRequestException;
import com.johnson.kevin.service.spotify.exception.SpotifyAuthenticationException;
import com.johnson.kevin.model.ArtistEntity;
import com.johnson.kevin.service.spotify.converters.SpotifyArtistEntityConverter;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.requests.data.artists.GetArtistRequest;

import java.io.IOException;

/**
 * A service to request information about a Spotify artist.
 */
public class SpotifyArtistLoader {

    /**
     * Retrieve information about a Spotify artist.
     * @param artistId the ID of the artist on Spotify
     * @return artist data parsed into a {@link ArtistEntity}
     * @throws SpotifyArtistRequestException if failed to retrieve artist data
     */
    public static ArtistEntity loadArist(String artistId)
        throws SpotifyArtistRequestException
    {
        SpotifyApi api;
        try {
            api = SpotifyApiManager.getApi();
        } catch (SpotifyAuthenticationException e) {
            throw new SpotifyArtistRequestException(e);
        }
        GetArtistRequest getArtistRequest = api
            .getArtist(artistId)
            .build();
        try {
            Artist artist = getArtistRequest.execute();
            return SpotifyArtistEntityConverter.toArtistEntity(artist);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new SpotifyArtistRequestException(e);
        }
    }
}
