from typing import List
import yt_dlp

def download_songs(ids: List[str], urls: List[str], path: str):
    """
    Download songs from the provided URLs as MP3 files.
    :param ids: list of song IDs
    :param urls: list of YouTube URLs
    :param path: path to store files
    :return:
    """
    for i in range(len(urls)):
        song_id = ids[i]
        song_url = urls[i]
        options = {
            "format": "bestaudio/best",
            "outtmpl": f"{path}/{song_id}.%(ext)s",
            "postprocessors": [{
                "key": "FFmpegExtractAudio",
                "preferredcodec": "mp3",
                "preferredquality": "192",
            }],
            "noplaylist": True,
        }
        with yt_dlp.YoutubeDL(options) as yt:
            yt.download(song_url)