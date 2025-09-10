select
    distinct p.user_id
from
    Purchases
    inner join Purchases p on p.user_id = Purchases.user_id
    and Purchases.purchase_id != p.purchase_id
where
    abs(
        datediff(Purchases.purchase_date, p.purchase_date)
    ) <= 7
order by
    p.user_id;