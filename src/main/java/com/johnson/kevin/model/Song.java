package com.johnson.kevin.model;

/**
 * Represents a Song with metadata.
 *
 * @param songName  name of the song
 * @param albumName name of the album
 * @param artists   list of artists
 * @param genres    list of genres
 * @param imageURI  URI pointing to cover art
 */
public record Song(String songName, String albumName, Multivalue<String> artists, Multivalue<String> genres, String imageURI) {
    public String toString() {
        return songName + " - " + artists;
    }
}