select
    sum(
        Boxes.apple_count + ifnull(Chests.apple_count, 0)
    ) apple_count,
    sum(
        Boxes.orange_count + ifnull(Chests.orange_count, 0)
    ) orange_count
from
    Boxes
    left join Chests on Boxes.chest_id = Chests.chest_id;