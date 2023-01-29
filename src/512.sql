select mid.player_id, device_id
from Activity
         right join (select player_id, min(event_date) min_date from Activity group by player_id) mid
                    on mid.player_id = Activity.player_id and Activity.event_date = mid.min_date;