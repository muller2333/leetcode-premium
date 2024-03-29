select
    product_id,
    year first_year,
    quantity,
    price
from
    (
        select
            product_id,
            year,
            quantity,
            price,
            rank() over (
                partition by product_id
                order by
                    year
            ) r
        from
            Sales
    ) mid
where
    r = 1;