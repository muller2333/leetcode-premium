select
    product_name,
    sale_date,
    count(sale_date) total
from
    (
        select
            lower(trim(product_name)) product_name,
            substring(sale_date, 1, 7) sale_date
        from
            Sales
    ) mid
group by
    product_name,
    sale_date
order by
    product_name,
    sale_date;