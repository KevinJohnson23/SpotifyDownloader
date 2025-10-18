package com.johnson.kevin.integration;

import com.johnson.kevin.service.spotify.exception.SpotifyPlaylistUrlException;
import com.johnson.kevin.service.spotify.exception.SpotifyPlaylistException;
import com.johnson.kevin.model.PlaylistEntity;
import com.johnson.kevin.service.SpotifyPlaylistService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for SpotifyService.
 */
public class SpotifyPlaylistServiceIT {

    @Test
    public void validUrlShouldCreatePlaylistEntity() throws SpotifyPlaylistException {
        String validUrl = "https://open.spotify.com/playlist/6g21ncpgXB3eevNTk9eUov?si=a552daafbea442e7";
        PlaylistEntity playlistEntity = SpotifyPlaylistService.getPlaylist(validUrl);
        assertNotNull(playlistEntity);
        assertEquals(
            3,
            playlistEntity.size()
        );
        assertEquals(
            "test",
            playlistEntity.getName()
        );
        assertEquals(
            "1. To Hell We Ride - lostprophets\n2. Rooftops - lostprophets\n3. Just Tonight - Jimmy Eat World",
            playlistEntity.toString()
        );
        assertEquals(
            "3NnVR2GBIzSGkvTzSfVpWP",
            playlistEntity.get(0).getId()
        );
        assertEquals(
            "6Vc9cDiVRKH013ycHKN9nr",
            playlistEntity.get(0).getAlbum().getId()
        );
        assertEquals(
            "https://i.scdn.co/image/ab67616d0000b273528c0fda8f7fc339ac33c9ff",
            playlistEntity.get(0).getAlbum().getImageUrl()
        );
    }

    @Test
    public void emptyPlaylistShouldCreatePlaylistEntity() throws SpotifyPlaylistException {
        String emptyUrl = "https://open.spotify.com/playlist/1Niuc1bhxXAgso9WxAAPgG?si=3c8af15c7c954dd4";
        PlaylistEntity playlistEntity = SpotifyPlaylistService.getPlaylist(emptyUrl);
        assertNotNull(playlistEntity);
        assertEquals(
            0,
            playlistEntity.size()
        );
        assertEquals(
            "test #2",
            playlistEntity.getName()
        );
        assertEquals(
            "",
            playlistEntity.toString()
        );
    }

    @Test
    public void invalidUrlShouldThrowException() {
        SpotifyPlaylistException exception = assertThrows(SpotifyPlaylistException.class, () -> {
            SpotifyPlaylistService.getPlaylist("");
        });
        assertInstanceOf(SpotifyPlaylistUrlException.class, exception.getCause());
    }
}
