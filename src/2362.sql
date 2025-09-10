select
    mid.product_id,
    quantity,
    quantity * price price
from
    Products
    right join (
        select
            *
        from
            Purchases
        where
            invoice_id = (
                select
                    invoice_id
                from
                    Products
                    right join Purchases on Purchases.product_id = Products.product_id
                group by
                    invoice_id
                order by
                    sum(price * quantity) desc,
                    invoice_id
                limit
                    1
            )
    ) mid on mid.product_id = Products.product_id;