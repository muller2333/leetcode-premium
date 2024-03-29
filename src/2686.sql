select
    order_date,
    round(sum(score) / count(score) * 100, 2) immediate_percentage
from
    (
        select
            order_date,
            if(order_date = customer_pref_delivery_date, 1, 0) score
        from
            Delivery
    ) mid
group by
    order_date
order by
    order_date;