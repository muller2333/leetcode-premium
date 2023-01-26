select seller_id
from (select sum(price) total, seller_id from Sales group by seller_id) mid
where total =
      (select max(total) from (select sum(price) total from Sales group by seller_id) mid2);