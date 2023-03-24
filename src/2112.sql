select airport_id
from (
         select departure_airport airport_id, flights_count
         from Flights
         union all
         select arrival_airport airport_id, flights_count
         from Flights
     ) mid
group by airport_id
having sum(flights_count) =
       (
           select max(total)
           from (
                    select sum(flights_count) total
                    from (
                             select departure_airport airport_id, flights_count
                             from Flights
                             union all
                             select arrival_airport airport_id, flights_count
                             from Flights
                         ) mid
                    group by airport_id) mid2
       )