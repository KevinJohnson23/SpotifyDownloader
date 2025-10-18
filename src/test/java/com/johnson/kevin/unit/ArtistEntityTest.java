package com.johnson.kevin.unit;

import com.johnson.kevin.model.ArtistEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for {@link ArtistEntity} model.
 */
public class ArtistEntityTest {

    @Test
    public void testToString() {
        ArtistEntity artist = new ArtistEntity(null, "someArtistName", null, null);
        assertEquals("someArtistName", artist.toString());
    }
}
