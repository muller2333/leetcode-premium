select
    interval_no,
    sum(order_count) total_orders
from
    (
        select
            if(
                minute mod 6 = 0,
                minute / 6,
                floor(minute / 6) + 1
            ) interval_no,
            order_count
        from
            Orders
    ) mid
group by
    interval_no
order by
    interval_no;