select
    name,
    ifnull(rest, 0) rest,
    ifnull(paid, 0) paid,
    ifnull(canceled, 0) canceled,
    ifnull(refunded, 0) refunded
from
    Product
    left join (
        select
            product_id,
            sum(rest) rest,
            sum(paid) paid,
            sum(canceled) canceled,
            sum(refunded) refunded
        from
            Invoice
        group by
            product_id
    ) mid on mid.product_id = Product.product_id
order by
    name;