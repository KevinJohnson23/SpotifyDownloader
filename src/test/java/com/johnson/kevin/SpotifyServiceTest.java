package com.johnson.kevin;

import com.johnson.kevin.exceptions.InvalidPlaylistUriException;
import com.johnson.kevin.model.Playlist;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for SpotifyService.
 */
public class SpotifyServiceTest {

    /**
     * Mock of SpotifyService singleton for testing
     */
    private static class SpotifyServiceMock {
        public static Playlist loadPlaylist(String uri) throws InvalidPlaylistUriException {
            if (uri == null) {
                throw new InvalidPlaylistUriException();
            }
            // Check URI matches Spotify playlist URI format
            Pattern pattern = Pattern.compile("^https://open\\.spotify\\.com/playlist/[a-zA-Z0-9]+");
            if (pattern.matcher(uri).find()) {
                return new Playlist("someName", uri);
            }
            throw new InvalidPlaylistUriException();
        }
    }

    @Test
    public void validUriShouldCreatePlaylist() throws InvalidPlaylistUriException {
        // Test 1
        String validUri = "https://open.spotify.com/playlist/6g21ncpgXB3eevNTk9eUov?si=a552daafbea442e7";
        Playlist playlist = SpotifyServiceMock.loadPlaylist(validUri);
        assertNotNull(playlist);
    }

    @Test
    public void invalidUriShouldThrowException() {
        // Test 2
        assertThrows(InvalidPlaylistUriException.class, () -> {
            SpotifyServiceMock.loadPlaylist("");
        });
    }
}