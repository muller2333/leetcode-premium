select
    team_id,
    team_name,
    points,
    rank() over (
        order by
            points desc
    ) position
from
    (
        select
            team_id,
            team_name,
            wins * 3 + draws points
        from
            TeamStats
    ) mid
order by
    points desc,
    team_name asc