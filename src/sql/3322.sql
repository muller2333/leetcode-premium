select
    season_id,
    team_id,
    team_name,
    points,
    goal_difference,
    rank() over(
        partition by season_id
        order by
            points desc,
            goal_difference desc,
            team_name desc
    ) position
from
    (
        select
            season_id,
            team_id,
            team_name,
            wins * 3 + draws points,
            goals_for - goals_against goal_difference
        from
            SeasonStats
    ) mid
order by
    season_id,
    position,
    team_name