from typing import List
import yt_dlp

def download_songs(urls: List[str], path: str):
    """
    Download songs from the provided URLs as MP3 files.
    :param urls: list of YouTube URLs
    :param path: path to store files
    :return:
    """
    options = {
        "format": "bestaudio/best",
        "outtmpl": f"{path}/%(title)s.%(ext)s",
        "postprocessors": [{
            "key": "FFmpegExtractAudio",
            "preferredcodec": "mp3",
            "preferredquality": "192",
        }],
        "noplaylist": True,
    }
    with yt_dlp.YoutubeDL(options) as yt:
        yt.download(urls)