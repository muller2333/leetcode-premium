select team_name, matches_played, points, goal_for, goal_against, (goal_for - goal_against) goal_diff
from Teams
         right join (select team_id,
                            count(points)     matches_played,
                            sum(points)       points,
                            sum(goal_for)     goal_for,
                            sum(goal_against) goal_against
                     from (select home_team_id    team_id,
                                  case
                                      when home_team_goals > away_team_goals then 3
                                      when home_team_goals < away_team_goals then 0
                                      else 1
                                      end         points,
                                  home_team_goals goal_for,
                                  away_team_goals goal_against
                           from Matches

                           union all

                           select away_team_id    team_id,
                                  case
                                      when home_team_goals < away_team_goals then 3
                                      when home_team_goals > away_team_goals then 0
                                      else 1
                                      end         points,
                                  away_team_goals goal_for,
                                  home_team_goals goal_against
                           from Matches) mid
                     group by team_id) mid2 on mid2.team_id = Teams.team_id
order by points desc, goal_diff desc, team_name;