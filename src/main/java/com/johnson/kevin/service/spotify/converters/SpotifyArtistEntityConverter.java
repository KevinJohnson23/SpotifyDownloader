package com.johnson.kevin.service.spotify.converters;

import com.johnson.kevin.model.ArtistEntity;
import com.johnson.kevin.model.EntityMultivalue;
import com.johnson.kevin.service.spotify.util.SpotifyImageUrlResolver;
import se.michaelthelin.spotify.model_objects.specification.Artist;

/**
 * A service to parse SpotifyApi {@link Artist} into {@link ArtistEntity}
 */
public class SpotifyArtistEntityConverter {

    /**
     * Convert {@link Artist} to {@link ArtistEntity}.
     * @param artist original {@link Artist} instance
     * @return new {@link ArtistEntity} instance
     */
    public static ArtistEntity toArtistEntity(Artist artist) {
        return new ArtistEntity(
            artist.getId(),
            artist.getName(),
            EntityMultivalue.fromArray(artist.getGenres()),
            SpotifyImageUrlResolver.getImageUrl(artist.getImages())
        );
    }
}