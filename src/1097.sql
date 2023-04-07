select install_dt, count(player_id) installs, round(sum(cnt) / count(player_id), 2) Day1_retention
from (select mid.player_id,
             install_dt,
             if(event_date is null, 0, 1) cnt
      from Activity
               right join (select player_id, min(event_date) install_dt from Activity group by player_id) mid
                          on mid.player_id = Activity.player_id and
                             date_add(mid.install_dt, interval 1 day) = Activity.event_date) mid2
group by install_dt;