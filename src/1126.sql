select business_id
from (select business_id, if(occurrences > avg_occurrences, 1, 0) diff
      from Events
               inner join(select event_type, avg(occurrences) avg_occurrences from Events group by event_type) mid
                         on mid.event_type = Events.event_type) mid2
group by business_id
having sum(diff) >= 2;
