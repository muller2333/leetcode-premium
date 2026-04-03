select
    product_id,
    name
from
    products
where
    (
        name regexp '[0-9][0-9][0-9]'
        and name not regexp '[0-9][0-9][0-9][0-9]'
    )
order by
    product_id