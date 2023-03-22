select from_id person1, to_id person2, count(duration) call_count, sum(duration) total_duration
from (select if(from_id > to_id, to_id, from_id) from_id, if(from_id > to_id, from_id, to_id) to_id, duration
      from Calls) mid
group by concat(from_id, to_id);