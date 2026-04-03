select
    artist,
    count(id) occurrences
from
    Spotify
group by
    artist
order by
    occurrences desc,
    artist;