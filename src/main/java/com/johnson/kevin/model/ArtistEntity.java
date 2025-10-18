package com.johnson.kevin.model;

/**
 * Represents an artist with metadata.
 */
public class ArtistEntity {

    private final String id;
    private final String name;
    private EntityMultivalue<String> genres;
    private String imageUrl;

    /**
     * Instantiate a new {@link ArtistEntity} with the provided information.
     * @param id ID of artist on Spotify
     * @param name name of artist
     * @param genres genres artist contributes to
     * @param imageUrl cover image for artist
     */
    public ArtistEntity(
        String id,
        String name,
        EntityMultivalue<String> genres,
        String imageUrl
    ) {
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EntityMultivalue<String> getGenres() {
        return genres;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setGenres(EntityMultivalue<String> genres) {
        this.genres = genres;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}