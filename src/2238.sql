select driver_id, ifnull(cnt, 0) cnt
from (select distinct driver_id from Rides) mid
         left join
     (select count(ride_id) cnt, passenger_id from Rides group by passenger_id) mid2
     on mid.driver_id = mid2.passenger_id;
