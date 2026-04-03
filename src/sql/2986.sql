select
    user_id,
    spend third_transaction_spend,
    transaction_date third_transaction_date
from
    (
        select
            user_id,
            spend,
            transaction_date,
            lag(spend, 1) over(
                partition by user_id
                order by
                    rn
            ) pre,
            lag(spend, 2) over(
                partition by user_id
                order by
                    rn
            ) pre2,
            rn
        from
            (
                select
                    user_id,
                    spend,
                    transaction_date,
                    row_number() over(
                        partition by user_id
                        order by
                            transaction_date
                    ) rn
                from
                    Transactions
            ) mid
    ) mid2
where
    rn = 3
    and spend > pre
    and spend > pre2
order by
    user_id;