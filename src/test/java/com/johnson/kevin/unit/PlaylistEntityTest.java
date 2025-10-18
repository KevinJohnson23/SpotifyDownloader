package com.johnson.kevin.unit;

import com.johnson.kevin.model.ArtistEntity;
import com.johnson.kevin.model.EntityMultivalue;
import com.johnson.kevin.model.PlaylistEntity;
import com.johnson.kevin.model.SongEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for {@link PlaylistEntity} model.
 */
public class PlaylistEntityTest {

    /**
     * Helper function to quickly create a {@link SongEntity}
     */
    private static SongEntity getSong() {
        EntityMultivalue<ArtistEntity> artists = new EntityMultivalue<>();
        artists.add(new ArtistEntity(null, "someArtistName", null, null));
        return new SongEntity(null, "someSongName", null, artists, null);
    }

    @Test
    public void testToStringSingleSong() {
        PlaylistEntity playlistEntity = new PlaylistEntity();
        playlistEntity.add(getSong());
        assertEquals("1. someSongName - someArtistName", playlistEntity.toString());
    }

    @Test
    public void testToStringMultipleSongs() {
        PlaylistEntity playlistEntity = new PlaylistEntity();
        playlistEntity.add(getSong());
        playlistEntity.add(getSong());
        assertEquals("1. someSongName - someArtistName\n2. someSongName - someArtistName", playlistEntity.toString());
    }

    @Test
    public void testToStringEmpty() {
        assertEquals("", new PlaylistEntity().toString());
    }
}
