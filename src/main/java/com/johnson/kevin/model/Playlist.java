package com.johnson.kevin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Playlist that may contain many Songs.
 */
public class Playlist {
    List<Song> songs;

    /**
     * Initialise songs list.
     */
    public Playlist() {
        this.songs = new ArrayList<>();
    }

    /**
     * Add Song to Playlist
     * @param song Song to add
     */
    public void add(Song song) {
        this.songs.add(song);
    }
}
