select user_id seller_id,
       if(item_brand is null, 'no', if(favorite_brand = item_brand, 'yes', 'no')) 2nd_item_fav_brand
from Users
         left join (select seller_id, item_brand
                    from (
                             select item_id, seller_id
                             from (select item_id, seller_id, rank() over (partition by seller_id order by order_date) r
                                   from Orders) mid
                             where r = 2
                         ) mid2
                             left join Items on Items.item_id = mid2.item_id) mid3
                   on mid3.seller_id = Users.user_id;