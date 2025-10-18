package com.johnson.kevin.service.spotify;

import com.johnson.kevin.exceptions.spotify.SpotifyArtistRequestException;
import com.johnson.kevin.model.ArtistEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Service to fill in missing artist details when Spotify API returns simplified artist details.
 */
public class SpotifyFillArtist {

    private static final Map<String, ArtistEntity> filledArtists = new HashMap<>();

    /**
     * Fill in the details of an existing {@link ArtistEntity}.
     * @param artist the {@link ArtistEntity} instance with missing details
     * @return the same {@link ArtistEntity} instance with filled in details
     */
    public static ArtistEntity fillArtist(ArtistEntity artist) throws SpotifyArtistRequestException {
        ArtistEntity filledArtist = filledArtists.get(artist.getId());
        if (filledArtist == null) {
            filledArtist = SpotifyArtistLoader.loadArist(artist.getId());
            filledArtists.put(filledArtist.getId(), filledArtist);
        }
        artist.setGenres(filledArtist.getGenres());
        artist.setImageUrl(filledArtist.getImageUrl());
        return artist;
    }
}
