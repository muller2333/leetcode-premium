select distinct viewer_id id
from (select view_date, viewer_id, count(distinct article_id) cnt from Views group by view_date, viewer_id) mid
where cnt > 1
order by id;