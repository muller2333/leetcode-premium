select
    id user1,
    round(100 * cnt / count, 2) percentage_popularity
from
    (
        select
            id,
            count(id2) cnt
        from
            (
                select
                    user1 id,
                    user2 id2
                from
                    Friends
                union
                select
                    user2 id,
                    user1 id2
                from
                    Friends
            ) mid
        group by
            id
    ) mid2
    join (
        select
            count(id) count
        from
            (
                select
                    user1 id
                from
                    Friends
                union
                select
                    user2 id
                from
                    Friends
            ) mid
    ) mid3
order by
    id;