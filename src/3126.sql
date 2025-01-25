with cte as (
    select
        server_id,
        status_time,
        session_status,
        row_number() over(
            partition by server_id,
            session_status
            order by
                status_time
        ) rn
    from
        Servers
)
select
    floor(
        sum(
            timestampdiff(second, cte.status_time, c.status_time) / 3600
        ) / 24
    ) total_uptime_days
from
    cte
    join cte c on cte.server_id = c.server_id
    and cte.rn = c.rn
    and cte.session_status != c.session_status
where
    cte.session_status = 'start'