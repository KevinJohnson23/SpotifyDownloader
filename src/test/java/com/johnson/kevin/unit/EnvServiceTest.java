package com.johnson.kevin.unit;

import com.johnson.kevin.service.EnvService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit test for {@link EnvService}.
 */
public class EnvServiceTest {

    @Test
    public void validNameShouldReturnValue() {
        assertNotNull(EnvService.get("SPOTIFY_CLIENT_SECRET"));
    }

    @Test
    public void invalidNameShouldReturnNull() {
        assertNull(EnvService.get(""));
    }
}
