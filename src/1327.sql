select
    product_name,
    unit
from
    Products
    right join (
        select
            product_id,
            sum(unit) unit
        from
            Orders
        where
            substring(order_date, 1, 7) = '2020-02'
        group by
            product_id
        having
            unit >= 100
    ) mid on mid.product_id = Products.product_id;