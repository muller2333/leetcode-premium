select query_name,
       round(avg(ratio), 2) quality,
       round(count(case when rating < 3 then 1 end) / count(ratio) * 100, 2) poor_query_percentage
from (select query_name, rating / position ratio, rating from Queries) mid
group by query_name;