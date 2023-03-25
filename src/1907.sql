select if(mid2.level = 'L', 'Low Salary', if(mid2.level = 'A', 'Average Salary', 'High Salary')) category,
       ifnull(cnt, 0)                                                                            accounts_count
from (select level, count(level) cnt
      from (
               select if(income < 20000, 'L', if(income <= 50000, 'A', 'H')) level from Accounts) mid
      group by level) mid
         right join
     (select 'L' level
      union
      select 'A' level
      union
      select 'H' level
     ) mid2
     on mid2.level = mid.level;