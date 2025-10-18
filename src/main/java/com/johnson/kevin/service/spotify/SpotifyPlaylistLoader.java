package com.johnson.kevin.service.spotify;

import com.johnson.kevin.exceptions.spotify.SpotifyAuthenticationException;
import com.johnson.kevin.exceptions.spotify.SpotifyPlaylistRequestException;
import com.johnson.kevin.model.PlaylistEntity;
import com.johnson.kevin.service.spotify.converters.SpotifyPlaylistEntityConverter;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Playlist;
import se.michaelthelin.spotify.requests.data.playlists.GetPlaylistRequest;

import java.io.IOException;

/**
 * A service to request information about a Spotify playlist.
 */
public class SpotifyPlaylistLoader {

    /**
     * Retrieve information about a Spotify playlist.
     * @param playlistId the ID of the playlist on Spotify
     * @return playlist data parsed into a {@link PlaylistEntity}
     * @throws SpotifyPlaylistRequestException if failed to retrieve data
     */
    public static PlaylistEntity loadPlaylist(String playlistId) throws SpotifyPlaylistRequestException {
        SpotifyApi api;
        try {
            api = SpotifyApiManager.getApi();
        } catch (SpotifyAuthenticationException e) {
            throw new SpotifyPlaylistRequestException(e);
        }
        GetPlaylistRequest getPlaylistRequest = api
            .getPlaylist(playlistId)
            .build();
        try {
            Playlist playlist = getPlaylistRequest.execute();
            return SpotifyPlaylistEntityConverter.toPlaylistEntity(playlist);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new SpotifyPlaylistRequestException(e);
        }
    }
}
