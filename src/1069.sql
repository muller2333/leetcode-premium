select mid.product_id, total_quantity
from Product
         right join (select product_id, sum(quantity) total_quantity from Sales group by product_id) mid
                    on mid.product_id = Product.product_id;