select business_id
from (select business_id, if(occurences > avg_occurences, 1, 0) diff
      from Events
               inner join(select event_type, avg(occurences) avg_occurences from Events group by event_type) mid
                         on mid.event_type = Events.event_type) mid2
group by business_id
having sum(diff) >= 2;