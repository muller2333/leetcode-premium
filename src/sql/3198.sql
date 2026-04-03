select
    state,
    group_concat(
        city
        order by
            city separator ', '
    ) cities
from
    cities
group by
    state