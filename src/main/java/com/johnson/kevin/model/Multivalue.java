package com.johnson.kevin.model;

import java.util.ArrayList;

/**
 * Represents a Song attribute that can contain many values (artists, genres, etc.).
 */
public class Multivalue<T> extends ArrayList<T> {
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
}
