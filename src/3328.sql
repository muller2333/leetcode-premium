select
    state,
    group_concat(
        city
        order by
            city separator ', '
    ) cities,
    sum(flag) matching_letter_count
from
    (
        select
            state,
            city,
            substring(city, 1, 1) = substring(state, 1, 1) flag
        from
            cities
    ) mid
group by
    state
having
    matching_letter_count > 0
    and count(state) >= 3
order by
    matching_letter_count desc,
    state