select
    city,
    peak_calling_hour,
    cnt number_of_calls
from
    (
        select
            rank() over(
                partition by city
                order by
                    cnt desc
            ) rk,
            city,
            cnt,
            h / 1 peak_calling_hour
        from
            (
                select
                    count(city) cnt,
                    city,
                    h
                from
                    (
                        select
                            substring(call_time, 11, 3) h,
                            city
                        from
                            Calls
                    ) mid
                group by
                    city,
                    h
            ) mid2
    ) mid3
where
    rk = 1
order by
    peak_calling_hour desc,
    city desc;