select
      customer_id,
      name
from
      Customers
where
      customer_id in (
            select
                  customer_id
            from
                  (
                        select
                              sum(cost) sum_cost,
                              customer_id
                        from
                              (
                                    select
                                          quantity * price cost,
                                          customer_id,
                                          substring(order_date, 1, 7) order_date
                                    from
                                          Product
                                          right join (
                                                select
                                                      *
                                                from
                                                      Orders
                                                where
                                                      substring(order_date, 1, 7) = '2020-06'
                                                      or substring(order_date, 1, 7) = '2020-07'
                                          ) mid on mid.product_id = Product.product_id
                              ) mid2
                        group by
                              order_date,
                              customer_id
                        having
                              sum(cost) >= 100
                  ) mid3
            group by
                  customer_id
            having
                  count(sum_cost) = 2
      );