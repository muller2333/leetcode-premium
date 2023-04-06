select Teams.team_id, team_name, ifnull(num_points, 0) num_points
from Teams
         left join (select sum(score) num_points, team_id
                    from (select case
                                     when host_goals < guest_goals then 0
                                     when host_goals > guest_goals then 3
                                     else 1
                                     end   score,
                                 host_team team_id
                          from Matches
                          union all
                          select case
                                     when host_goals < guest_goals then 3
                                     when host_goals > guest_goals then 0
                                     else 1
                                     end    score,
                                 guest_team team_id
                          from Matches) mid
                    group by team_id) mid2 on mid2.team_id = Teams.team_id
order by num_points desc, Teams.team_id;