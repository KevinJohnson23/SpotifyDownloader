def filter_title(video_info, include, exclude) -> str | None:
    """
    Filter a video's title by include and exclude lists.
    :param video_info: video info returned by YtDlp
    :param include: list of words that must ALL be in the title
    :param exclude: list of words that must NOT be in the title
    :return: None if title is valid, or message of what was flagged in the title
    """
    title = video_info["title"].lower()
    for word in include:
        if not word.lower() in title:
            return f"Title does not contain {word}."
    for word in exclude:
        if word.lower() in title:
            return f"Title contains {word}."
    return None