select
    year,
    product_id,
    curr_year_spend,
    prev_year_spend,
    if(
        prev_year_spend is null,
        null,
        round(
            (curr_year_spend - prev_year_spend) / prev_year_spend * 100,
            2
        )
    ) yoy_rate
from
    (
        select
            year,
            product_id,
            spend curr_year_spend,
            lag(spend, 1) over(
                partition by product_id
                order by
                    year
            ) prev_year_spend
        from
            (
                select
                    product_id,
                    year,
                    sum(spend) spend
                from
                    (
                        select
                            transaction_id,
                            product_id,
                            spend,
                            substring(transaction_date, 1, 4) / 1 year
                        from
                            user_transactions
                    ) mid
                group by
                    product_id,
                    year
            ) mid2
    ) mid3
order by
    product_id,
    year