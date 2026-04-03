with tmp as (
    select
        seat_id,
        free
    from
        Cinema
    union
    all
    select
        max(seat_id) + 1 seat_id,
        0 free
    from
        Cinema
)
select
    min_id - cnt first_seat_id,
    min_id -1 last_seat_id,
    cnt consecutive_seats_len
from
    (
        select
            min_id,
            cnt,
            rank() over(
                order by
                    cnt desc
            ) rk
        from
            (
                select
                    min_id,
                    count(min_id) cnt
                from
                    (
                        select
                            seat_id,
                            min(s_id) min_id
                        from
                            (
                                select
                                    tmp.seat_id,
                                    t.seat_id s_id,
                                    tmp.free
                                from
                                    tmp
                                    left join tmp t on tmp.seat_id < t.seat_id
                                    and t.free = 0
                                    and tmp.free = 1
                            ) mid
                        group by
                            seat_id
                    ) mid2
                group by
                    min_id
            ) mdi3
    ) mid4
where
    rk = 1