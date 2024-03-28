select
    lower(trim(product_name)) product_name,
    substring(sale_date, 1, 7) sale_date,
    count(sale_date) total
from
    Sales
group by
    upper(trim(product_name)),
    substring(sale_date, 1, 7)
order by
    product_name,
    sale_date;