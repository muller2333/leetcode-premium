select
      name customer_name,
      mid2.customer_id,
      order_id,
      order_date
from
      Customers
      right join (
            select
                  customer_id,
                  order_id,
                  order_date
            from
                  (
                        select
                              order_id,
                              customer_id,
                              order_date,
                              rank() over (
                                    partition by customer_id
                                    order by
                                          order_date desc
                              ) r
                        from
                              Orders
                  ) mid
            where
                  r <= 3
      ) mid2 on mid2.customer_id = Customers.customer_id
order by
      customer_name,
      mid2.customer_id,
      order_date desc;