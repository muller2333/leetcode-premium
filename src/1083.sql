select
  distinct buyer_id
from
  Sales
where
  product_id = (
    select
      product_id
    from
      Product
    where
      product_name = 'S8'
  )
  and buyer_id not in (
    select
      distinct buyer_id
    from
      Sales
    where
      product_id = (
        select
          product_id
        from
          Product
        where
          product_name = 'iPhone'
      )
  );