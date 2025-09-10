select
      mid3.city_id,
      mid3.day,
      degree
from
      Weather
      right join (
            select
                  city_id,
                  min(day) day
            from
                  (
                        select
                              day,
                              mid.city_id
                        from
                              Weather
                              right join (
                                    select
                                          city_id,
                                          max(degree) degree
                                    from
                                          Weather
                                    group by
                                          city_id
                              ) mid on mid.city_id = Weather.city_id
                              and Weather.degree = mid.degree
                  ) mid2
            group by
                  city_id
      ) mid3 on mid3.city_id = Weather.city_id
      and mid3.day = Weather.day
order by
      mid3.city_id;