from typing import List
from filter import filter_title
import yt_dlp

INCLUDE = []
EXCLUDE = ["live", "cover", "tab", "karaoke", "remix"]

MAX_RESULTS = 1
DURATION_THRESHOLD = 20

def get_song_url(query, duration) -> str:
    """
    Get the best-matching YouTube video's URL for a specified song query and duration
    :param query: the song search query
    :param duration: the duration to aim for
    :return: URL of best-matching video
    """
    attempt = 0
    candidates = []
    while True:
        attempt += 1
        search_url = f"ytsearch{MAX_RESULTS*attempt}:{query}"
        with yt_dlp.YoutubeDL() as yt:
            info = yt.extract_info(search_url, download=False)
        if "entries" not in info:
            return info["webpage_url"]
        valid_titles = []
        entries = info["entries"][(attempt-1)*MAX_RESULTS:]
        for video_info in entries:
            is_valid_title = filter_title(video_info, INCLUDE, EXCLUDE)
            if is_valid_title:
                print(is_valid_title)
                continue
            else:
                valid_titles.append(video_info)
        if len(valid_titles) == 0:
            continue
        candidates.extend(valid_titles)
        candidates.sort(key=lambda x: abs(int(x["duration"]) - duration))
        if abs(candidates[0]["duration"] - duration) <= DURATION_THRESHOLD:
            return candidates[0]["webpage_url"]

def get_song_urls(queries: List[str], durations: List[int]) -> List[str]:
    """
    Get a list of song URLs from the specified queries and constraints
    :param queries: list of YouTube search queries
    :param durations: list of durations to try to match
    :return: list of URLs that are the mos appropriate for each song
    """
    song_urls = []
    for i in range(len(queries)):
        query = queries[i]
        duration = durations[i]
        song_urls.append(get_song_url(query, duration))
    return song_urls