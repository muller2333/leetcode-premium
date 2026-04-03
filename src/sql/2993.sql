select
    week_of_month,
    purchase_date,
    total_amount
from
    (
        SELECT
            week(purchase_date) - week('2023-11-01') + 1 week_of_month,
            purchase_date,
            sum(amount_spend) total_amount
        from
            Purchases
        where
            WEEKDAY(purchase_date) = 4
        group by
            purchase_date
    ) mid
order by
    week_of_month;