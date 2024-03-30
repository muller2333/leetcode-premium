select
    substring(pair, 1, position(',' in pair) - 1) / 1 user_id,
    substring(pair, position(',' in pair) + 1) / 1 recommended_id
from
    (
        select
            pair
        from
            (
                select
                    concat(mid2.user_id, ',', mid3.user_id) pair,
                    mid2.song_id,
                    mid2.day
                from
                    (
                        select
                            distinct user_id,
                            mid.song_id,
                            mid.day
                        from
                            Listens
                            right join (
                                select
                                    day,
                                    song_id
                                from
                                    Listens
                                group by
                                    day,
                                    song_id
                                having
                                    count(distinct user_id) >= 2
                            ) mid on mid.day = Listens.day
                            and mid.song_id = Listens.song_id
                    ) mid2
                    inner join (
                        select
                            distinct user_id,
                            mid.song_id,
                            mid.day
                        from
                            Listens
                            right join (
                                select
                                    day,
                                    song_id
                                from
                                    Listens
                                group by
                                    day,
                                    song_id
                                having
                                    count(distinct user_id) >= 2
                            ) mid on mid.day = Listens.day
                            and mid.song_id = Listens.song_id
                    ) mid3 on mid2.day = mid3.day
                    and mid2.song_id = mid3.song_id
                    and mid2.user_id < mid3.user_id
            ) mid4
        where
            pair not in (
                select
                    concat(user1_id, ',', user2_id)
                from
                    Friendship
            )
        group by
            pair,
            day
        having
            count(song_id) >= 3
        union
        select
            pair
        from
            (
                select
                    concat(mid2.user_id, ',', mid3.user_id) pair,
                    mid2.song_id,
                    mid2.day
                from
                    (
                        select
                            distinct user_id,
                            mid.song_id,
                            mid.day
                        from
                            Listens
                            right join (
                                select
                                    day,
                                    song_id
                                from
                                    Listens
                                group by
                                    day,
                                    song_id
                                having
                                    count(distinct user_id) >= 2
                            ) mid on mid.day = Listens.day
                            and mid.song_id = Listens.song_id
                    ) mid2
                    inner join (
                        select
                            distinct user_id,
                            mid.song_id,
                            mid.day
                        from
                            Listens
                            right join (
                                select
                                    day,
                                    song_id
                                from
                                    Listens
                                group by
                                    day,
                                    song_id
                                having
                                    count(distinct user_id) >= 2
                            ) mid on mid.day = Listens.day
                            and mid.song_id = Listens.song_id
                    ) mid3 on mid2.day = mid3.day
                    and mid2.song_id = mid3.song_id
                    and mid2.user_id > mid3.user_id
            ) mid4
        where
            pair not in (
                select
                    concat(user2_id, ',', user1_id)
                from
                    Friendship
            )
        group by
            pair,
            day
        having
            count(song_id) >= 3
    ) mid7;