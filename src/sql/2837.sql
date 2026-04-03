select
    Users.user_id,
    name,
    ifnull(total, 0) 'traveled distance'
from
    Users
    left join (
        select
            user_id,
            sum(distance) total
        from
            Rides
        group by
            user_id
    ) mid on mid.user_id = Users.user_id
order by
    Users.user_id;