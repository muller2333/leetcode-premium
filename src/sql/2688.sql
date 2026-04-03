select
    distinct user_id
from
    (
        select
            user_id,
            created_at,
            lead(created_at, 1) over (
                partition by user_id
                order by
                    created_at
            ) next
        from
            Users
    ) mid
where
    next is not null
    and datediff(next, created_at) <= 7;