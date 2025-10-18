from typing import List
from get_song_urls import  get_song_urls
from download_songs import download_songs

DEFAULT_PATH = "downloads/"

def download(queries: List[str], durations: List[int], path: str = None):
    """
    Get a song from YouTube based on the query.
    :param queries: list of YouTube search queries
    :param durations list of song duration for each query
    :param path: optional path to download songs to
    :return:
    """
    path = path if path is not None else DEFAULT_PATH
    song_urls = get_song_urls(queries, durations)
    download_songs(song_urls, path)