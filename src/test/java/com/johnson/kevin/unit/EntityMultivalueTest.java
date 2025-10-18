package com.johnson.kevin.unit;

import com.johnson.kevin.model.EntityMultivalue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for {@link EntityMultivalue} model.
 */
public class EntityMultivalueTest {

    @Test
    public void testToStringSingle() {
        EntityMultivalue<String> mv = new EntityMultivalue<>();
        mv.add("element1");
        assertEquals("element1", mv.toString());
    }

    @Test
    public void testToStringMultiple() {
        EntityMultivalue<String> mv = new EntityMultivalue<>();
        mv.add("element1");
        mv.add("element2");
        assertEquals("element1, element2", mv.toString());
    }

    @Test
    public void testToStringEmpty() {
        assertEquals("", new EntityMultivalue<>().toString());
    }

    @Test
    public void testFromArray() {
        String[] array = {"element1", "element2"};
        EntityMultivalue<String> mv = EntityMultivalue.fromArray(array);
        assertEquals("element1, element2", mv.toString());
    }
}
