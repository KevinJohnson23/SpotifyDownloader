package com.johnson.kevin.model;

/**
 * Represents a Song with metadata.
 */
public class SongEntity {

    private final String id;
    private final String name;
    private AlbumEntity album;
    private EntityMultivalue<ArtistEntity> artists;
    private final Integer durationMs;

    /**
     * Instantiate a new {@link SongEntity} with the provided information.
     * @param id ID of song on Spotify
     * @param name name of song
     * @param album album song belongs to
     * @param artists artists contributing to the song
     * @param durationMs duration of song in milliseconds
     */
    public SongEntity(
        String id,
        String name,
        AlbumEntity album,
        EntityMultivalue<ArtistEntity> artists,
        Integer durationMs
    ) {
        this.id = id;
        this.name = name;
        this.album = album;
        this.artists = artists;
        this.durationMs = durationMs;
    }

    @Override
    public String toString() {
        return name + " - " + artists;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AlbumEntity getAlbum() {
        return album;
    }

    public EntityMultivalue<ArtistEntity> getArtists() {
        return artists;
    }

    public Integer getDurationMs() {
        return durationMs;
    }

    public void setAlbum(AlbumEntity album) {
        this.album = album;
    }

    public void setArtists(EntityMultivalue<ArtistEntity> artists) {
        this.artists = artists;
    }
}