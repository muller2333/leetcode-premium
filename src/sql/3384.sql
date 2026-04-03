with cte as (
    select
        team_name,
        concat(',', group_concat(player_id separator ','), ',') ids
    from
        Teams
    group by
        team_name
)
select
    team_name,
    half_number,
    sum(val) dominance
from
    (
        select
            team_name,
            if(time_stamp <= '45:00', 1, 2) half_number,
            if(position(pass_to in ids) != 0, 1, -1) val
        from
            Passes
            join (
                select
                    ids,
                    player_id,
                    cte.team_name
                from
                    cte
                    join Teams on cte.team_name = Teams.team_name
            ) mid on Passes.pass_from = mid.player_id
    ) mid2
group by
    team_name,
    half_number
order by
    team_name,
    half_number