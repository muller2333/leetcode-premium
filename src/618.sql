select America, Asia, Europe
from (select rownum, America, Asia
      from (select name America, @rownum := @rownum + 1 rownum
            from Student,
                 (select @rownum := 0) rownum
            where continent = 'America'
            order by name) mid
               left join (select name Asia, @rownum2 := @rownum2 + 1 rownum2
                          from Student,
                               (select @rownum2 := 0) rownum2
                          where continent = 'Asia'
                          order by name) mid2 on mid.rownum = mid2.rownum2) mid3
         left join (select name Europe, @rownum3 := @rownum3 + 1 rownum3
                    from Student,
                         (select @rownum3 := 0) rownum3
                    where continent = 'Europe'
                    order by name) mid4 on mid4.rownum3 = mid3.rownum;