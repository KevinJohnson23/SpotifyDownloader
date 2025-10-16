package com.johnson.kevin;

import com.johnson.kevin.model.Multivalue;
import com.johnson.kevin.model.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for Song model.
 */
public class SongTest {

    @Test
    public void testToString() {
        Multivalue<String> artists = new Multivalue<>();
        artists.add("someArtistName");
        Song song = new Song("someSongName", null, artists, null, null);
        assertEquals("someSongName - someArtistName", song.toString());
    }
}
