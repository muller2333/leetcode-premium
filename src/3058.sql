select
    user_id1,
    user_id2
from
    Friends
where
    concat(
        user_id1,
        ',',
        user_id2
    ) not in (
        select
            id
        from
            (
                select
                    concat(Friends.user_id1, ',', f.user_id2) id
                from
                    Friends
                    join Friends f
                where
                    Friends.user_id2 = f.user_id1
                union
                select
                    concat(Friends.user_id2, ',', f.user_id1) id
                from
                    Friends
                    join Friends f
                where
                    Friends.user_id1 = f.user_id2
                union
                select
                    concat(Friends.user_id2, ',', f.user_id2) id
                from
                    Friends
                    join Friends f
                where
                    Friends.user_id1 = f.user_id1
                union
                select
                    concat(Friends.user_id1, ',', f.user_id1) id
                from
                    Friends
                    join Friends f
                where
                    Friends.user_id2 = f.user_id2
            ) mid
    )
order by
    user_id1,
    user_id2;