select
      customer_id,
      customer_name
from
      Customers
where
      customer_id in (
            select
                  customer_id
            from
                  (
                        select
                              distinct customer_id,
                              product_name
                        from
                              Orders
                        where
                              customer_id not in (
                                    select
                                          distinct customer_id
                                    from
                                          Orders
                                    where
                                          product_name = 'C'
                              )
                              and (
                                    product_name = 'A'
                                    or product_name = 'B'
                              )
                  ) mid
            group by
                  customer_id
            having
                  count(customer_id) >= 2
      );