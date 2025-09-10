select
    distinct substring(pair, 1, position(',' in pair) - 1) / 1 user1_id,
    substring(pair, position(',' in pair) + 1) / 1 user2_id
from
    (
        select
            concat(mid.user_id, ',', mid2.user_id) pair
        from
            (
                select
                    distinct user_id,
                    song_id,
                    day
                from
                    Listens
            ) mid
            inner join (
                select
                    distinct user_id,
                    song_id,
                    day
                from
                    Listens
            ) mid2 on mid.song_id = mid2.song_id
            and mid.day = mid2.day
            and mid.user_id < mid2.user_id
        group by
            mid.user_id,
            mid2.user_id,
            mid.day
        having
            count(*) >= 3
    ) mid3
where
    pair in (
        select
            concat(user1_id, ',', user2_id)
        from
            Friendship
    );