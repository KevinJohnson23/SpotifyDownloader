package com.johnson.kevin.service;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Service to get .env variables
 */
public class EnvService {
    private static final Dotenv dotenv = Dotenv.load();

    /**
     * Load an environment variable from .env
     * @param key name of variable
     * @return value under variable
     */
    public static String get(String key) {
        return dotenv.get(key);
    }
}