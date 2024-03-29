select
    user_id,
    steps_date,
    round((count + count2 + steps_count) / 3, 2) rolling_average
from
    (
        select
            user_id,
            steps_count,
            steps_date,
            lag(steps_date, 2) over(
                partition by user_id
                order by
                    steps_date
            ) pre2,
            lag(steps_count, 1) over(
                partition by user_id
                order by
                    steps_date
            ) count,
            lag(steps_count, 2) over(
                partition by user_id
                order by
                    steps_date
            ) count2
        from
            Steps
    ) mid
where
    datediff(steps_date, pre2) = 2
order by
    user_id,
    steps_date;