package com.johnson.kevin.service.youtube.util;

import java.util.List;

/**
 * Utility to parse a list of arguments into a string acceptable for a CLI argument.
 */
public class YouTubeParseList {

    private static final String DELIMITER = "\u001F";

    /**
     * Parse a list of strings into a string that can be given to the Python script as a CLI argument.
     * @param list the list to parse
     * @return a single string representing the list
     */
    public static String parseList(List<String> list) {
        return String.join(DELIMITER, list);
    }
}
