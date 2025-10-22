package com.johnson.kevin.service.youtube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class YouTubeDownloader {

    /**
     * Run the process to download the songs from YouTube.
     * @param command the list of commands to run
     * @throws InterruptedException if failed to start process
     * @throws IOException if failed to wait for process to finish
     */
    public static void runProcess(List<String> command)
        throws InterruptedException, IOException
    {
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectErrorStream(true);
        Process process = pb.start();
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Python script failed with exit code: " + exitCode);
        }
    }
}
