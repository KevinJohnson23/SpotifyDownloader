package com.johnson.kevin.model;

import java.util.ArrayList;

/**
 * Represents a Playlist that may contain many Songs.
 */
public class Playlist extends ArrayList<Song> {
    String name;

    /**
     * Initialise songs list and set specified name.
     */
    public Playlist(String name) {
        super();
        this.name = name;
    }

    /**
     * @return "{position}. {song name} - {artist names}"
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            builder.append(i).append(". ").append(this.get(i)).append("\n");
        }
        return builder.toString();
    }
}
