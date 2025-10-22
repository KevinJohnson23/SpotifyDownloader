import sys
from downloader import download

DELIMITER = "\u001F"

if __name__ == "__main__":
    ids = sys.argv[1].split(DELIMITER)
    queries = sys.argv[2].split(DELIMITER)
    durations = [int(d.strip()) for d in sys.argv[3].split(DELIMITER)]
    path = sys.argv[4] if len(sys.argv) > 4 else None
    download(ids, queries, durations, path)