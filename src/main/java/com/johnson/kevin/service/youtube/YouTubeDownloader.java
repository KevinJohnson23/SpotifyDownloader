package com.johnson.kevin.service.youtube;

import com.johnson.kevin.model.PlaylistEntity;
import com.johnson.kevin.model.SongEntity;
import com.johnson.kevin.service.youtube.exception.YouTubeDownloadException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A service to download the songs in a {@link PlaylistEntity}
 */
public class YouTubeDownloader {

    private static final String pythonScript = "python/main.py";

    private static List<String> getQueries(PlaylistEntity playlist) {
        return playlist.stream().map(SongEntity::toString).toList();
    }

    private static List<String> getDurations(PlaylistEntity playlist) {
        return playlist.stream().map(song -> (song.getDurationMs() / 1000)).map(Object::toString).toList();
    }

    private static String parseList(List<String> queries) {
        String delimiter = "\u001F";
        return String.join(delimiter, queries);
    }

    private static List<String> formCommand(List<String> queries, List<String> durations, String path) {
        List<String> command = new ArrayList<>();
        command.add("python");
        command.add(pythonScript);
        command.add(parseList(queries));
        command.add(parseList(durations));
        command.add(path);
        return command;
    }

    private static void runProcess(ProcessBuilder pb) throws InterruptedException, IOException {
        pb.redirectErrorStream(true);
        Process process = pb.start();
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Python script failed with exit code: " + exitCode);
        }
    }

    public static void downloadPlaylist(PlaylistEntity playlist, String path) throws YouTubeDownloadException {
        List<String> queries = getQueries(playlist);
        List<String> durations = getDurations(playlist);
        List<String> command = formCommand(queries, durations, path);
        ProcessBuilder pb = new ProcessBuilder(command);
        try {
            runProcess(pb);
        } catch (InterruptedException | IOException e) {
            throw new YouTubeDownloadException(e);
        }
    }

    public static void downloadPlaylist(PlaylistEntity playlist) throws YouTubeDownloadException {
        downloadPlaylist(playlist, null);
    }
}
