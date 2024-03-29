select
      name warehouse_name,
      sum(vol) volume
from
      (
            select
                  name,
                  WareHouse.product_id p_id,
                  units * ifnull(vol, 0) vol
            from
                  WareHouse
                  left join (
                        select
                              Width * Length * Height vol,
                              product_id
                        from
                              Products
                  ) mid on mid.product_id = WareHouse.product_id
      ) mid2
group by
      name;