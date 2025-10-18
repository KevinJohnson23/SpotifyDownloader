package com.johnson.kevin.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a Song attribute that can contain many values (artists, genres, etc.).
 */
public class EntityMultivalue<T> extends ArrayList<T> {
    
    /**
     * @return "{value1}, {value2}" ... ", {valueN}"
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            builder.append(this.get(i));
            if (i != this.size() - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    /**
     * Fill a new {@link EntityMultivalue} with elements from an array.
     * @param array the array to fill in values from
     * @return new {@link EntityMultivalue} instance with values filled in
     */
    public static <T> EntityMultivalue<T> fromArray(T[] array) {
        EntityMultivalue<T> multivalue = new EntityMultivalue<>();
        multivalue.addAll(Arrays.asList(array));
        return multivalue;
    }
}
