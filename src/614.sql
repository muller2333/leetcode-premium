select
    followee follower,
    count(follower) num
from
    Follow
where
    followee in (
        select
            follower
        from
            Follow
    )
group by
    followee
order by
    follower;