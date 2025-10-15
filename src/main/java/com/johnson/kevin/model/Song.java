package com.johnson.kevin.model;

import java.util.List;

/**
 * Represents a Song with metadata.
 *
 * @param songName  name of the song
 * @param albumName name of the album
 * @param artists   list of artists
 * @param genres    list of genres
 * @param imageURI  URI pointing to cover art
 */
public record Song(String songName, String albumName, List<String> artists, List<String> genres, String imageURI) { }