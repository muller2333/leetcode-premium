select
    week_of_month,
    purchase_date,
    ifnull(total_amount, 0) total_amount
from
    (
        select
            week(mid.purchase_date) - week('2023-11-01') + 1 week_of_month,
            mid.purchase_date,
            sum(amount_spend) total_amount
        from
            (
                select
                    '2023-11-03' purchase_date
                union
                select
                    '2023-11-10' purchase_date
                union
                select
                    '2023-11-17' purchase_date
                union
                select
                    '2023-11-24' purchase_date
            ) mid
            left join Purchases on mid.purchase_date = Purchases.purchase_date
        group by
            mid.purchase_date
    ) mid2
order by
    week_of_month;