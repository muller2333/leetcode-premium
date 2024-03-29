select
    customer_id,
    mid4.product_id,
    product_name
from
    (
        select
            mid2.customer_id,
            mid2.product_id
        from
            (
                select
                    customer_id,
                    max(count) mcount
                from
                    (
                        select
                            customer_id,
                            count(order_date) count
                        from
                            Orders
                        group by
                            customer_id,
                            product_id
                    ) mid
                group by
                    customer_id
            ) mid3
            left join (
                select
                    customer_id,
                    product_id,
                    count(order_date) count
                from
                    Orders
                group by
                    customer_id,
                    product_id
            ) mid2 on mid2.count = mid3.mcount
            and mid2.customer_id = mid3.customer_id
    ) mid4
    left join Products on Products.product_id = mid4.product_id;