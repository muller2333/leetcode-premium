select
    name country
from
    Country
where
    country_code in (
        select
            city_id
        from
            (
                select
                    sum(duration) / sum(cnt) avg_duration,
                    city_id
                from
                    (
                        select
                            distinct substring(phone_number, 1, 3) city_id,
                            id
                        from
                            Person
                    ) mid
                    right join (
                        select
                            c_id,
                            sum(duration) duration,
                            count(c_id) cnt
                        from
                            (
                                select
                                    caller_id c_id,
                                    duration
                                from
                                    Calls
                                union
                                all
                                select
                                    callee_id c_id,
                                    duration
                                from
                                    Calls
                            ) mid2
                        group by
                            c_id
                    ) mid3 on mid3.c_id = mid.id
                group by
                    city_id
            ) mid4
        where
            avg_duration > (
                select
                    sum(duration) / count(duration)
                from
                    Calls
            )
    );