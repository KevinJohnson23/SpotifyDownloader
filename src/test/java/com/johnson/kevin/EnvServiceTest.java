package com.johnson.kevin;

import com.johnson.kevin.service.EnvService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit test for EnvService.
 */
public class EnvServiceTest {

    @Test
    public void validNameShouldReturnValue() {
        // Test 2
        assertNotNull(EnvService.get("SPOTIFY_CLIENT_ID"));
    }

    @Test
    public void invalidNameShouldReturnNull() {
        // Test 2
        assertNull(EnvService.get(""));
    }
}
