package com.johnson.kevin.unit;

import com.johnson.kevin.service.spotify.exception.SpotifyPlaylistUrlException;
import com.johnson.kevin.service.spotify.exception.SpotifyPlaylistException;
import com.johnson.kevin.model.PlaylistEntity;

import com.johnson.kevin.service.SpotifyPlaylistService;
import com.johnson.kevin.service.spotify.util.SpotifyPlaylistUrlValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for {@link SpotifyPlaylistService}.
 */
public class SpotifyPlaylistServiceTest {

    /**
     * Mock of SpotifyService singleton for testing
     */
    private static class SpotifyPlaylistServiceMock {
        /**
         * Extract ID of playlist from URL.
         * @param url URL of playlist on Spotify
         * @return ID of playlist on Spotify
         * @throws SpotifyPlaylistException if invalid URL given
         */
        private static String getId(String url) throws SpotifyPlaylistException {
            try {
                return SpotifyPlaylistUrlValidator.getId(url);
            } catch (SpotifyPlaylistUrlException e) {
                throw new SpotifyPlaylistException(e);
            }
        }

        public static PlaylistEntity getPlaylist(String url) throws SpotifyPlaylistException {
            String playlistId = getId(url);
            return new PlaylistEntity(playlistId, "someName", "someImageUrl");
        }
    }

    @Test
    public void validUrlShouldCreatePlaylist() throws SpotifyPlaylistException {
        String validUrl = "https://open.spotify.com/playlist/6g21ncpgXB3eevNTk9eUov?si=a552daafbea442e7";
        PlaylistEntity playlistEntity = SpotifyPlaylistServiceMock.getPlaylist(validUrl);
        assertNotNull(playlistEntity);
    }

    @Test
    public void invalidUrlShouldThrowException() {
        SpotifyPlaylistException exception = assertThrows(SpotifyPlaylistException.class, () -> {
            SpotifyPlaylistServiceMock.getPlaylist("");
        });
        assertInstanceOf(SpotifyPlaylistUrlException.class, exception.getCause());
    }
}