package com.johnson.kevin.unit;

import com.johnson.kevin.service.spotify.exception.SpotifyPlaylistUrlException;
import com.johnson.kevin.service.spotify.util.SpotifyPlaylistUrlValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for {@link SpotifyPlaylistUrlValidator}.
 */
public class SpotifyPlaylistUrlValidatorTest {

    @Test
    public void validUrlShouldReturnId() throws SpotifyPlaylistUrlException {
        String validUrl = "https://open.spotify.com/playlist/6g21ncpgXB3eevNTk9eUov";
        assertEquals("6g21ncpgXB3eevNTk9eUov", SpotifyPlaylistUrlValidator.getId(validUrl));
    }

    @Test
    public void validUrlWithParametersShouldReturnId() throws SpotifyPlaylistUrlException {
        String validUrl = "https://open.spotify.com/playlist/6g21ncpgXB3eevNTk9eUov?si=a552daafbea442e7";
        assertEquals("6g21ncpgXB3eevNTk9eUov", SpotifyPlaylistUrlValidator.getId(validUrl));
    }

    @Test
    public void invalidUrlShouldThrowException() {
        String invalidUrl = "https://open.spotify.com/song/6g21ncpgXB3eevNTk9eUov?si=a552daafbea442e7";
        assertThrows(SpotifyPlaylistUrlException.class, () -> {
            SpotifyPlaylistUrlValidator.getId(invalidUrl);
        });
    }
}
