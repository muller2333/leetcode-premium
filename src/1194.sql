select group_id, player_id
from (select mid2.player_id, group_id, rank() over (partition by group_id order by total desc,mid2.player_id asc) r
      from (select sum(score) total, player_id
            from (select first_player player_id, first_score score
                  from Matches
                  union all
                  select second_player player_id, second_score score
                  from Matches) mid
            group by player_id) mid2
               left join Players on Players.player_id = mid2.player_id) mid3
where r = 1;