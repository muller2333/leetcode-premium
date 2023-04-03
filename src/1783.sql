select mid2.player_id, player_name, grand_slams_count
from Players
         right join (select count(year) grand_slams_count, player_id
                     from (select year, Wimbledon player_id
                           from Championships
                           union all
                           select year, Fr_open player_id
                           from Championships
                           union all
                           select year, US_open player_id
                           from Championships
                           union all
                           select year, Au_open player_id
                           from Championships) mid
                     group by player_id) mid2 on mid2.player_id = Players.player_id;