package com.johnson.kevin.service.spotify.converters;

import com.johnson.kevin.model.SongEntity;
import se.michaelthelin.spotify.model_objects.specification.Track;

/**
 * A service to parse SpotifyApi {@link Track} into {@link SongEntity}
 */
public class SpotifySongEntityConverter {

    /**
     * Convert {@link Track} to {@link SongEntity}.
     * @param track original {@link Track} instance
     * @return new {@link SongEntity} instance
     */
    public static SongEntity toSongEntity(Track track) {
        return new SongEntity(
            track.getId(),
            track.getName(),
            null,
            SpotifyArtistsEntityListConverter.toArtistsEntityList(track.getArtists()),
            track.getDurationMs()
        );
    }
}