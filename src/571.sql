select round(avg(num), 1) median
from ((select num
       from (select num, (select sum(frequency) from Numbers where num <= n.num) total from Numbers n) mid
       where total >=
             (select floor((1 + (select sum(frequency) from Numbers)) / 2))
       order by total
       limit 1)
      union all
      (select num
       from (select num, (select sum(frequency) from Numbers where num >= n.num) total from Numbers n) mid
       where total >=
             (select floor((1 + (select sum(frequency) from Numbers)) / 2))
       order by total
       limit 1)) mid2;