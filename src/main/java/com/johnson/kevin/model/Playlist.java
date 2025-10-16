package com.johnson.kevin.model;

import java.util.ArrayList;

/**
 * Represents a Playlist that may contain many Songs.
 */
public class Playlist extends ArrayList<Song> {
    String name;
    String uri;

    /**
     * Initialise songs list and set specified name and URI.
     */
    public Playlist(String name, String uri) {
        super();
        this.name = name;
        this.uri = uri;
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
}
