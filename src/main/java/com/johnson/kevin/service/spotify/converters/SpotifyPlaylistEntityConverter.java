package com.johnson.kevin.service.spotify.converters;

import com.johnson.kevin.model.PlaylistEntity;
import com.johnson.kevin.service.spotify.util.SpotifyImageUrlResolver;
import se.michaelthelin.spotify.model_objects.specification.Playlist;

/**
 * A service to parse SpotifyApi {@link Playlist} into {@link PlaylistEntity}
 */
public class SpotifyPlaylistEntityConverter {

    /**
     * Convert {@link Playlist} to {@link PlaylistEntity}.
     * @param playlist original {@link Playlist} instance
     * @return new {@link PlaylistEntity} instance
     */
    public static PlaylistEntity toPlaylistEntity(Playlist playlist) {
        return new PlaylistEntity(
            playlist.getId(),
            playlist.getName(),
            SpotifyImageUrlResolver.getImageUrl(playlist.getImages())
        );
    }
}
