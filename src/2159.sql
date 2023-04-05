select first_col, second_col
from (select first_col, @rownum := @rownum + 1 rownum
      from Data,
           (select @rownum := 0) rownum
      order by first_col) mid
         inner join
     (select second_col, @rownum2 := @rownum2 + 1 rownum
      from Data,
           (select @rownum2 := 0) rownum
      order by second_col desc) mid2
     on mid.rownum = mid2.rownum;