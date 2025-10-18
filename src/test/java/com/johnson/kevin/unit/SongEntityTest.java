package com.johnson.kevin.unit;

import com.johnson.kevin.model.ArtistEntity;
import com.johnson.kevin.model.EntityMultivalue;
import com.johnson.kevin.model.SongEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for {@link SongEntity} model.
 */
public class SongEntityTest {

    @Test
    public void testToStringSingleArtist() {
        EntityMultivalue<ArtistEntity> artists = new EntityMultivalue<>();
        artists.add(new ArtistEntity(null, "someArtistName", null, null));
        SongEntity songEntity = new SongEntity(null, "someSongName", null, artists, null);
        assertEquals("someSongName - someArtistName", songEntity.toString());
    }

    @Test
    public void testToStringMultipleArtists() {
        EntityMultivalue<ArtistEntity> artists = new EntityMultivalue<>();
        artists.add(new ArtistEntity(null, "someArtistName", null, null));
        artists.add(new ArtistEntity(null, "someArtistName", null, null));
        SongEntity songEntity = new SongEntity(null, "someSongName", null, artists, null);
        assertEquals("someSongName - someArtistName, someArtistName", songEntity.toString());
    }
}
