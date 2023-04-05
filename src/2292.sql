select distinct mid.product_id
from (select product_id, year
      from (select product_id, substring(purchase_date, 1, 4) year from Orders) mid
      group by product_id, year
      having count(product_id) >= 3) mid
         inner join
     (select product_id, year + 1 year
      from (select product_id, substring(purchase_date, 1, 4) year from Orders) mid
      group by product_id, year
      having count(product_id) >= 3) mid2 on mid.product_id = mid2.product_id and mid.year = mid2.year;