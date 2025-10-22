package com.johnson.kevin.service.youtube.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility to form a CLI command with specific arguments.
 */
public class YouTubeFormCommand {

    private static final String PYTHON_SCRIPT = "python/main.py";

    /**
     * Form the CLI command to call for the Python script.
     * @param ids list of ids for each song in string form
     * @param queries list of search queries in string form
     * @param durations list of song durations in string form
     * @param path path to download songs to
     * @return command to run
     */
    public static List<String> formCommand(String ids, String queries, String durations, String path) {
        List<String> command = new ArrayList<>();
        command.add("python");
        command.add(PYTHON_SCRIPT);
        command.add(ids);
        command.add(queries);
        command.add(durations);
        command.add(path);
        return command;
    }
}
