package com.johnson.kevin.model;

import java.util.ArrayList;

/**
 * Represents a Playlist that may contain many Songs.
 */
public class PlaylistEntity extends ArrayList<SongEntity> {

    private String id;
    private String name;
    private String imageUrl;

    /**
     * Initialise playlist and set specified name and URLs.
     * @param id ID of playlist on Spotify
     * @param name name of playlist
     * @param imageUrl URL pointing to playlist cover image
     */
    public PlaylistEntity(String id, String name, String imageUrl) {
        super();
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    /**
     * Initialise playlist with empty attributes
     */
    public PlaylistEntity() {
        super();
    }

    /**
     * @return "{position}. {song name} - {artist names}"
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            builder.append(i+1).append(". ").append(this.get(i));
            if (i != this.size() - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return this.id;
    }

    public void setUrl(String id) {
        this.id = id;
    }
}
