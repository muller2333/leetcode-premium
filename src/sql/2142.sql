select
     bus_id,
     diff passengers_cnt
from
     (
          select
               mid4.cnt - ifnull(mid5.cnt, 0) diff,
               rownum
          from
               (
                    select
                         cnt,
                         @rownum := @rownum + 1 rownum
                    from
                         (
                              select
                                   ifnull(cnt, 0) cnt
                              from
                                   Buses
                                   left join (
                                        select
                                             count(passenger_id) cnt,
                                             bus_id
                                        from
                                             (
                                                  select
                                                       bus_id,
                                                       passenger_id
                                                  from
                                                       Buses,
                                                       Passengers
                                                  where
                                                       Passengers.arrival_time <= Buses.arrival_time
                                             ) mid
                                        group by
                                             bus_id
                                   ) mid2 on mid2.bus_id = Buses.bus_id
                         ) mid3,
                         (
                              select
                                   @rownum := 0
                         ) rownum
                    order by
                         cnt
               ) mid4
               left join (
                    select
                         cnt,
                         @rownum2 := @rownum2 + 1 rownum2
                    from
                         (
                              select
                                   ifnull(cnt, 0) cnt
                              from
                                   Buses
                                   left join (
                                        select
                                             count(passenger_id) cnt,
                                             bus_id
                                        from
                                             (
                                                  select
                                                       bus_id,
                                                       passenger_id
                                                  from
                                                       Buses,
                                                       Passengers
                                                  where
                                                       Passengers.arrival_time <= Buses.arrival_time
                                             ) mid
                                        group by
                                             bus_id
                                   ) mid2 on mid2.bus_id = Buses.bus_id
                         ) mid3,
                         (
                              select
                                   @rownum2 := 1
                         ) rownum
                    order by
                         cnt
               ) mid5 on mid4.rownum = mid5.rownum2
     ) mid6
     inner join (
          select
               bus_id,
               @rownum3 := @rownum3 + 1 rownum3
          from
               Buses,
               (
                    select
                         @rownum3 := 0
               ) rownum
          order by
               arrival_time asc
     ) mid7 on rownum3 = rownum
order by
     bus_id;