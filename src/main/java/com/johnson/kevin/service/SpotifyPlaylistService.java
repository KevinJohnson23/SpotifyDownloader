package com.johnson.kevin.service;

import com.johnson.kevin.model.ArtistEntity;
import com.johnson.kevin.model.EntityMultivalue;
import com.johnson.kevin.model.PlaylistEntity;
import com.johnson.kevin.model.SongEntity;
import com.johnson.kevin.service.spotify.SpotifyFillArtist;
import com.johnson.kevin.service.spotify.SpotifyPlaylistItemsLoader;
import com.johnson.kevin.service.spotify.SpotifyPlaylistLoader;
import com.johnson.kevin.service.spotify.exception.*;
import com.johnson.kevin.service.spotify.util.SpotifyPlaylistUrlValidator;

import java.util.List;

/**
 * Service to get playlist information from Spotify.
 */
public class SpotifyPlaylistService {

    /**
     * Extract ID of playlist from URL.
     * @param url URL of playlist on Spotify
     * @return ID of playlist on Spotify
     * @throws SpotifyPlaylistException if invalid URL given
     */
    private static String getId(String url)
        throws SpotifyPlaylistException
    {
        try {
            return SpotifyPlaylistUrlValidator.getId(url);
        } catch (SpotifyPlaylistUrlException e) {
            throw new SpotifyPlaylistException(e);
        }
    }

    /**
     * Create {@link PlaylistEntity} with only metadata attached (no songs).
     * @param playlistId ID of playlist on Spotify
     * @return new {@link PlaylistEntity} instance
     * @throws SpotifyPlaylistException if failed to load playlist
     */
    private static PlaylistEntity loadPlaylistBase(String playlistId)
        throws SpotifyPlaylistException
    {
        try {
            return SpotifyPlaylistLoader.loadPlaylist(playlistId);
        } catch (SpotifyPlaylistRequestException e) {
            throw new SpotifyPlaylistException(e);
        }
    }

    /**
     * Create {@link List} of songs in playlist with basic {@link ArtistEntity} instances.
     * @param playlistId ID of playlist on Spotify
     * @return list of {@link SongEntity} instances
     * @throws SpotifyPlaylistException if failed to load songs
     */
    private static List<SongEntity> loadPlaylistSongs(String playlistId)
        throws SpotifyPlaylistException
    {
        try {
            return SpotifyPlaylistItemsLoader.loadPlaylistItems(playlistId);
        } catch (SpotifyPlaylistItemsRequestException e) {
            throw new SpotifyPlaylistException(e);
        }
    }

    /**
     * Fill in missing attributes for artists contributing to an entity, i.e. song or album.
     * @param artists {@link EntityMultivalue} of artists
     * @throws SpotifyPlaylistException if failed to fill in missing attributes
     */
    private static void fillEntityArtists(EntityMultivalue<ArtistEntity> artists)
        throws SpotifyPlaylistException
    {
        for (ArtistEntity artist : artists) {
            try {
                SpotifyFillArtist.fillArtist(artist);
            } catch (SpotifyArtistRequestException e) {
                throw new SpotifyPlaylistException(e);
            }
        }
    }

    /**
     * Fill in missing attributes for artists contributing to a list of songs.
     * @param songs List of songs
     * @throws SpotifyPlaylistException if failed to fill in missing attributes
     */
    private static void fillSongListArtists(List<SongEntity> songs)
        throws SpotifyPlaylistException
    {
        for (SongEntity song : songs) {
            fillEntityArtists(song.getArtists());
            fillEntityArtists(song.getAlbum().getArtists());
        }
    }

    /**
     * Get a playlist from Spotify.
     * @param url Link to spotify playlist e.g. "https://open.spotify.com/playlist/6g21ncpgXB3eevNTk9eUov"
     * @return list of songs
     * @throws SpotifyPlaylistException if failed to load playlist
     */
    public static PlaylistEntity getPlaylist(String url) throws SpotifyPlaylistException {
        String playlistId = getId(url);
        PlaylistEntity playlist = loadPlaylistBase(playlistId);
        List<SongEntity> songs = loadPlaylistSongs(playlistId);
        fillSongListArtists(songs);
        playlist.addAll(songs);
        return playlist;
    }
}
