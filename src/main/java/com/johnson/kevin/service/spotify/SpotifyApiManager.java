package com.johnson.kevin.service.spotify;

import com.johnson.kevin.exceptions.spotify.SpotifyAuthenticationException;
import com.johnson.kevin.service.EnvService;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

import java.io.IOException;

/**
 * A service to manage authentication with the Spotify API.
 */
public class SpotifyApiManager {

    private static SpotifyApi api;

    /**
     * Set access token for Spotify client ID and secret.
     * @throws SpotifyAuthenticationException if failed to authenticate client ID and/or secret
     */
    private static void initializeApi() throws SpotifyAuthenticationException {
        api = new SpotifyApi.Builder()
            .setClientId(EnvService.get("SPOTIFY_CLIENT_ID"))
            .setClientSecret(EnvService.get("SPOTIFY_CLIENT_SECRET"))
            .build();
        ClientCredentialsRequest clientCredentialsRequest = api
            .clientCredentials()
            .build();
        try {
            ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            api.setAccessToken(clientCredentials.getAccessToken());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new SpotifyAuthenticationException(e);
        }
    }

    /**
     * Get the SpotifyApi instance, and initialize it if not already done.
     * @return authenticated {@link SpotifyApi} instance
     * @throws SpotifyAuthenticationException if failed to authenticate client ID and/or secret
     */
    public static SpotifyApi getApi() throws SpotifyAuthenticationException {
        if (api == null)
            initializeApi();
        return api;
    }
}
