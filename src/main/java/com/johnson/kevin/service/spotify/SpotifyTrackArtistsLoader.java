package com.johnson.kevin.service.spotify;

import com.johnson.kevin.service.spotify.exception.SpotifyArtistRequestException;
import com.johnson.kevin.model.ArtistEntity;
import com.johnson.kevin.model.EntityMultivalue;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;

/**
 * A service to request information about a Spotify song's contributing artists.
 */
public class SpotifyTrackArtistsLoader {

    /**
     * Retrieve information about a Spotify song's contributing artists.
     * @param artists list of {@link ArtistSimplified} array
     * @return list of {@link ArtistEntity}
     * @throws SpotifyArtistRequestException if failed to retrieve artist data
     */
    public static EntityMultivalue<ArtistEntity> loadTrackArtists(ArtistSimplified[] artists)
        throws SpotifyArtistRequestException
    {
        EntityMultivalue<ArtistEntity> artistsMultivalue = new EntityMultivalue<>();
        for (ArtistSimplified artist : artists) {
            ArtistEntity artistEntity = SpotifyArtistLoader.loadArist(artist.getId());
            artistsMultivalue.add(artistEntity);
        }
        return artistsMultivalue;
    }
}
