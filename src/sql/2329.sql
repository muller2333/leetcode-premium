select
     user_id,
     sum(quantity * price) spending
from
     Sales
     inner join Product on Product.product_id = Sales.product_id
group by
     user_id
order by
     spending desc,
     user_id;