import sys
from downloader import download

DELIMITER = "\u001F"

if __name__ == "__main__":
    queries = sys.argv[1].split(DELIMITER)
    durations = [int(d.strip()) for d in sys.argv[2].split(DELIMITER)]
    path = sys.argv[3] if len(sys.argv) > 3 else None
    download(queries, durations, path)