select
    seller_id,
    cnt num_items
from
    (
        select
            seller_id,
            cnt,
            rank() over(
                order by
                    cnt desc
            ) rk
        from
            (
                select
                    seller_id,
                    count(item_id) cnt
                from
                    (
                        select
                            mid2.seller_id,
                            item_id
                        from
                            (
                                select
                                    seller_id,
                                    mid.item_id,
                                    item_brand
                                from
                                    (
                                        select
                                            seller_id,
                                            item_id
                                        from
                                            Orders
                                        group by
                                            seller_id,
                                            item_id
                                    ) mid
                                    left join Items on Items.item_id = mid.item_id
                            ) mid2
                            left join Users on mid2.seller_id = Users.seller_id
                            and favorite_brand != item_brand
                        where
                            Users.seller_id is not null
                    ) mid3
                group by
                    seller_id
            ) mid4
    ) mid5
where
    rk = 1
order by
    seller_id;