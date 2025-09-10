select
    Teams.team_name home_team,
    mid.team_name away_team
from
    Teams
    inner join Teams mid on Teams.team_name != mid.team_name;