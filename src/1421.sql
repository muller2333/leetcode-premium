select substring(year_id, 5) + 0 id, substring(year_id, 1, 4) + 0 year, npv
from (select mid.year_id, ifnull(npv, 0) npv
      from (select concat(year, id) year_id from Queries) mid
               left join (select concat(year, id) year_id, npv from NPV) mid2 on mid.year_id = mid2.year_id) mid3;