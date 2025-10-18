package com.johnson.kevin.model;

/**
 * Represents an album with metadata.
 */
public class AlbumEntity {

    private final String id;
    private final String name;
    private EntityMultivalue<ArtistEntity> artists;
    private final String releaseDate;
    private final String imageUrl;

    /**
     * Instantiate a new {@link AlbumEntity} with the provided information.
     * @param id ID of album on Spotify
     * @param name name of album
     * @param artists artists contributing to the album
     * @param releaseDate release date of album
     */
    public AlbumEntity(
        String id,
        String name,
        EntityMultivalue<ArtistEntity> artists,
        String releaseDate,
        String imageUrl
    ) {
        this.id = id;
        this.name = name;
        this.artists = artists;
        this.releaseDate = releaseDate;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EntityMultivalue<ArtistEntity> getArtists() {
        return artists;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setArtists(EntityMultivalue<ArtistEntity> artists) {
        this.artists = artists;
    }
}