select round(100 * count(delivery_id) / (select count(delivery_id) from Delivery all_count), 2) immediate_percentage
from Delivery
where order_date = customer_pref_delivery_date