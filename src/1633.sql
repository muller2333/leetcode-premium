select
    contest_id,
    round(
        100 * count(user_id) / (
            select
                count(user_id)
            from
                Users
        ),
        2
    ) percentage
from
    Register
group by
    contest_id
order by
    percentage desc,
    contest_id;