select
    mid2.user_id,
    cnt sessions_count
from
    (
        select
            user_id,
            count(session_id) cnt
        from
            (
                select
                    *
                from
                    Sessions
                where
                    session_type = 'Streamer'
            ) mid
        group by
            user_id
    ) mid3
    right join (
        select
            user_id
        from
            (
                select
                    user_id,
                    row_number() over(
                        partition by user_id
                        order by
                            session_start
                    ) rn,
                    session_type
                from
                    Sessions
            ) mid
        where
            rn = 1
            and session_type = 'Viewer'
    ) mid2 on mid2.user_id = mid3.user_id
where
    cnt is not null
order by
    cnt desc,
    user_id desc;