select
    week_of_month,
    mid5.membership,
    ifnull(total_amount, 0) total_amount
from
    (
        select
            '2023-11-03' day,
            1 week_of_month,
            'Premium' membership
        union
        select
            '2023-11-10' day,
            2 week_of_month,
            'Premium' membership
        union
        select
            '2023-11-17' day,
            3 week_of_month,
            'Premium' membership
        union
        select
            '2023-11-24' day,
            4 week_of_month,
            'Premium' membership
        union
        select
            '2023-11-03' day,
            1 week_of_month,
            'VIP' membership
        union
        select
            '2023-11-10' day,
            2 week_of_month,
            'VIP' membership
        union
        select
            '2023-11-17' day,
            3 week_of_month,
            'VIP' membership
        union
        select
            '2023-11-24' day,
            4 week_of_month,
            'VIP' membership
    ) mid5
    left join (
        select
            membership,
            purchase_date,
            total_amount
        from
            (
                select
                    membership,
                    purchase_date,
                    sum(amount_spend) total_amount
                from
                    (
                        select
                            mid2.user_id,
                            purchase_date,
                            amount_spend,
                            membership
                        from
                            (
                                select
                                    user_id,
                                    purchase_date,
                                    amount_spend
                                from
                                    Purchases
                                where
                                    purchase_date in (
                                        '2023-11-03',
                                        '2023-11-10',
                                        '2023-11-17',
                                        '2023-11-24'
                                    )
                            ) mid
                            join (
                                select
                                    user_id,
                                    membership
                                from
                                    Users
                                where
                                    membership != 'Standard'
                            ) mid2 on mid2.user_id = mid.user_id
                    ) mid3
                group by
                    purchase_date,
                    membership
            ) mid4
    ) mid6 on mid6.purchase_date = mid5.day
    and mid6.membership = mid5.membership
order by
    week_of_month,
    membership;