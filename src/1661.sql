select machine_id, round(sum(used_time) / count(used_time), 3) processing_time
from (select substring(mid.ids, 1, locate(',', mid.ids) - 1) + 0 machine_id, mid2.timestamp - mid.timestamp used_time
      from (select concat(machine_id, ',', process_id) ids, timestamp from Activity where activity_type = 'start') mid
               inner join
           (select concat(machine_id, ',', process_id) ids, timestamp from Activity where activity_type = 'end') mid2
           on mid.ids = mid2.ids) mid3
group by machine_id;