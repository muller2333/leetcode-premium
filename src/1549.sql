select product_name, mid2.product_id, order_id, order_date
from Products
         right join (select mid.order_date, mid.product_id, order_id
                     from Orders
                              right join (select max(order_date) order_date, product_id
                                          from Orders
                                          group by product_id) mid on mid.product_id = Orders.product_id and
                                                                      Orders.order_date = mid.order_date) mid2
                    on mid2.product_id = Products.product_id
order by product_name, mid2.product_id, order_id;