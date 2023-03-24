select bus_id, diff passengers_cnt
from (select mid2.cnt - ifnull(mid3.cnt, 0) diff, rownum
      from (
               select cnt, @rownum := @rownum + 1 rownum
               from (
                        select ifnull(cnt, 0) cnt
                        from Buses
                                 left join (select count(passenger_id) cnt, bus_id
                                            from (select bus_id, passenger_id
                                                  from Buses,
                                                       Passengers
                                                  where Passengers.arrival_time <= Buses.arrival_time) mid
                                            group by bus_id) mid0 on mid0.bus_id = Buses.bus_id) mid,
                    (select @rownum := 0) rownum
               order by cnt) mid2
               left join
           (select cnt, @rownum2 := @rownum2 + 1 rownum2
            from (
                     select ifnull(cnt, 0) cnt
                     from Buses
                              left join (select count(passenger_id) cnt, bus_id
                                         from (select bus_id, passenger_id
                                               from Buses,
                                                    Passengers
                                               where Passengers.arrival_time <= Buses.arrival_time) mid
                                         group by bus_id) mid0 on mid0.bus_id = Buses.bus_id
                 ) mid,
                 (select @rownum2 := 1) rownum
            order by cnt) mid3
           on mid2.rownum = mid3.rownum2) mid4
         inner join
     (select bus_id, @rownum3 := @rownum3 + 1 rownum3
      from Buses,
           (select @rownum3 := 0) rownum
      order by arrival_time asc) mid5 on rownum3 = rownum
order by bus_id;