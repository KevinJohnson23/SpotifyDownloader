package com.johnson.kevin.service.spotify.converters;

import com.johnson.kevin.model.ArtistEntity;
import com.johnson.kevin.model.EntityMultivalue;
import com.johnson.kevin.model.PlaylistEntity;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Playlist;

/**
 * A service to parse SpotifyApi {@link Playlist} into {@link PlaylistEntity}
 */
public class SpotifyArtistsEntityListConverter {

    /**
     * Convert {@link ArtistSimplified} array to {@link ArtistEntity} multivalue.
     * @param artists {@link ArtistSimplified} array
     * @return multivalue of {@link ArtistEntity} instances
     */
    public static EntityMultivalue<ArtistEntity> toArtistsEntityList(ArtistSimplified[] artists) {
        EntityMultivalue<ArtistEntity> artistsMultivalue = new EntityMultivalue<>();
        for (ArtistSimplified artist : artists) {
            ArtistEntity artistEntity = new ArtistEntity(
                artist.getId(),
                artist.getName(),
                null,
                null
            );
            artistsMultivalue.add(artistEntity);
        }
        return artistsMultivalue;
    }
}
