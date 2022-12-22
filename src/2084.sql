select *
from Orders
where order_type = 0
   or customer_id not in
      (select customer_id from Orders where order_type = 0 group by customer_id having count(order_type) >= 1);
