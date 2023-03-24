select customer_id
from (
         select distinct customer_id, product_key
         from Customer
     ) mid
group by customer_id
having count(product_key) = (select count(product_key) from Product);