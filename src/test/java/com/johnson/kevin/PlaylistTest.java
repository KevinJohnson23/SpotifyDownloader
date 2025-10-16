package com.johnson.kevin;

import com.johnson.kevin.model.Multivalue;
import com.johnson.kevin.model.Playlist;
import com.johnson.kevin.model.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for Playlist model.
 */
public class PlaylistTest {

    /**
     * Helper function to quickly create a Song
     */
    private static Song getSong() {
        Multivalue<String> artists = new Multivalue<>();
        artists.add("someArtistName");
        return new Song("someSongName", null, artists, null, null);
    }

    @Test
    public void testToStringSingleSong() {
        // Test 1
        Playlist playlist = new Playlist("somePlaylistName", "someURI");
        playlist.add(getSong());
        assertEquals("1. someSongName - someArtistName", playlist.toString());
    }

    @Test
    public void testToStringMultipleSongs() {
        // Test 2
        Playlist playlist = new Playlist("somePlaylistName", "someURI");
        playlist.add(getSong());
        playlist.add(getSong());
        assertEquals("1. someSongName - someArtistName\n2. someSongName - someArtistName", playlist.toString());
    }

    @Test
    public void testToStringEmpty() {
        // Test 3
        Playlist playlist = new Playlist("somePlaylistName", "someURI");
        assertEquals("", playlist.toString());
    }
}
