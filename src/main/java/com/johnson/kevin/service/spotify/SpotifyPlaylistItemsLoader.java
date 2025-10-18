package com.johnson.kevin.service.spotify;

import com.johnson.kevin.exceptions.spotify.SpotifyAuthenticationException;
import com.johnson.kevin.exceptions.spotify.SpotifyPlaylistItemsRequestException;
import com.johnson.kevin.model.SongEntity;
import com.johnson.kevin.service.spotify.converters.SpotifyAlbumEntityConverter;
import com.johnson.kevin.service.spotify.converters.SpotifySongEntityConverter;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.playlists.GetPlaylistsItemsRequest;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A service to request information about the items in a Spotify playlist.
 */
public class SpotifyPlaylistItemsLoader {

    private static final int PLAYLIST_PAGE_LIMIT = 20;

    /**
     * Retrieve a single page of a Spotify playlist.
     * @param playlistId the ID of the playlist on Spotify
     * @param pageNum the current page to retrieve
     * @return a {@link Paging} instance containing the items on that page
     * @throws SpotifyPlaylistItemsRequestException if failed to retrieve page
     */
    private static Paging<PlaylistTrack> loadPage(String playlistId, int pageNum)
        throws SpotifyPlaylistItemsRequestException
    {
        SpotifyApi api;
        try {
            api = SpotifyApiManager.getApi();
        } catch (SpotifyAuthenticationException e) {
            throw new SpotifyPlaylistItemsRequestException(e);
        }
        GetPlaylistsItemsRequest getPlaylistsItemsRequest = api
            .getPlaylistsItems(playlistId)
            .offset(pageNum*PLAYLIST_PAGE_LIMIT)
            .limit(PLAYLIST_PAGE_LIMIT)
            .build();
        try {
            return getPlaylistsItemsRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new SpotifyPlaylistItemsRequestException(e);
        }
    }

    /**
     * Retrieve a list of the items in a Spotify playlist.
     * @param playlistId the ID of the playlist on Spotify
     * @return {@link ArrayList} of item information parsed into {@link SongEntity}
     * @throws SpotifyPlaylistItemsRequestException if failed to retrieve playlist items data
     */
    public static ArrayList<SongEntity> loadPlaylistItems(String playlistId)
        throws SpotifyPlaylistItemsRequestException
    {
        ArrayList<SongEntity> songs = new ArrayList<>();
        int pageNum = 0;
        Paging<PlaylistTrack> page;
        do {
            page = loadPage(playlistId, pageNum);
            for (PlaylistTrack item: page.getItems()) {
                Track track = (Track) item.getTrack();
                SongEntity song = SpotifySongEntityConverter.toSongEntity(track);
                song.setAlbum(SpotifyAlbumEntityConverter.toAlbumEntity(track.getAlbum()));
                songs.add(song);
            }
            pageNum++;
        } while (page.getNext() != null);
        return songs;
    }
}