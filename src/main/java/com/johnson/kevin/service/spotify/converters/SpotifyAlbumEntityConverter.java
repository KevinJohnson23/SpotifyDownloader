package com.johnson.kevin.service.spotify.converters;

import com.johnson.kevin.model.AlbumEntity;
import com.johnson.kevin.service.spotify.util.SpotifyImageUrlResolver;
import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;

/**
 * A service to parse SpotifyApi {@link Album} into {@link AlbumEntity}
 */
public class SpotifyAlbumEntityConverter {

    /**
     * Convert {@link Album} to {@link AlbumEntity}.
     * @param album original {@link Album} instance
     * @return new {@link AlbumEntity} instance
     */
    public static AlbumEntity toAlbumEntity(Album album) {
        return new AlbumEntity(
            album.getId(),
            album.getName(),
            SpotifyArtistsEntityListConverter.toArtistsEntityList(album.getArtists()),
            album.getReleaseDate(),
            album.getImages()[0].getUrl()
        );
    }

    /**
     * Convert {@link AlbumSimplified} to {@link AlbumEntity}.
     * @param album original {@link AlbumSimplified} instance
     * @return new {@link AlbumEntity} instance
     */
    public static AlbumEntity toAlbumEntity(AlbumSimplified album) {
        return new AlbumEntity(
            album.getId(),
            album.getName(),
            SpotifyArtistsEntityListConverter.toArtistsEntityList(album.getArtists()),
            album.getReleaseDate(),
            SpotifyImageUrlResolver.getImageUrl(album.getImages())
        );
    }
}
