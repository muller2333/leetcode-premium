select month, count(distinct (customer_id)) order_count, count(customer_id) customer_count
from (select customer_id, substring(order_date, 1, 7) month from Orders where invoice > 20) mid
group by month;