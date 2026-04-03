select
    order_id
from
    (
        select
            order_id,
            max(quantity) max_salary
        from
            OrdersDetails
        group by
            order_id
    ) mid
where
    max_salary > (
        select
            max(avg_salary) max_avg_salary
        from
            (
                select
                    avg(quantity) avg_salary
                from
                    OrdersDetails
                group by
                    order_id
            ) mid2
    );