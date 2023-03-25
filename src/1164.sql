select mid.product_id, new_price price
from Products
         right join (
    select product_id, max(change_date) change_date
    from Products
    where change_date <= '2019-08-16'
    group by product_id) mid on mid.change_date = Products.change_date and mid.product_id = Products.product_id
union
select distinct product_id, 10 price
from Products
where product_id not in (select distinct product_id from Products where change_date <= '2019-08-16');