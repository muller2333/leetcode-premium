select seller_name
from Seller
where seller_id not in (select seller_id
                        from Orders
                        where substring(sale_date, 1, 4) = '2020'
                        group by seller_id
                        having count(order_id) > 0)
order by seller_name;