select
    *
from
    (
        select
            Inventory.item_id,
            Inventory.square_footage,
            ifnull(inv.square_footage, 0) small
        from
            Inventory
            join Inventory inv on Inventory.item_type = 'prime_eligible'
            and Inventory.item_type = inv.item_type
            and Inventory.square_footage >= inv.square_footage
    ) mid
group by
    item_id