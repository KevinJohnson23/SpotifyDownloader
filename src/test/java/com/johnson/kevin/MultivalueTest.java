package com.johnson.kevin;

import com.johnson.kevin.model.Multivalue;
import com.johnson.kevin.model.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for Multivalue model.
 */
public class MultivalueTest {

    @Test
    public void testToStringNotEmpty() {
        // Test 1
        Multivalue<String> mv = new Multivalue<>();
        mv.add("element1");
        mv.add("element2");
        assertEquals("element1, element2", mv.toString());
    }

    @Test
    public void testToStringEmpty() {
        // Test 2
        Multivalue<String> mv = new Multivalue<>();
        assertEquals("", mv.toString());
    }
}
