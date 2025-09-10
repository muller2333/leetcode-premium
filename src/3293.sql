select
    product_id,
    if(
        discount is null,
        price,
        price *(1 - discount / 100)
    ) final_price,
    Products.category
from
    Products
    left join Discounts on Discounts.category = Products.category
order by
    product_id