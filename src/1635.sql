select mid4.month, active_drivers, ifnull(accepted_rides, 0) accepted_rides
from (select substring(month, 6) / 1 month, count(driver_id) active_drivers
      from (select driver_id, mid2.month
            from (select driver_id,
                         if(length(join_date) = 10, substring(join_date, 1, 7),
                            concat(substring(join_date, 1, 5), '-', substring(join_date, 6, 1))) month
                  from Drivers
                  where substring(join_date, 1, 4) <= '2020') mid
                     right join
                 (
                     select '2020-01' month
                     union all
                     select '2020-02' month
                     union all
                     select '2020-03' month
                     union all
                     select '2020-04' month
                     union all
                     select '2020-05' month
                     union all
                     select '2020-06' month
                     union all
                     select '2020-07' month
                     union all
                     select '2020-08' month
                     union all
                     select '2020-09' month
                     union all
                     select '2020-10' month
                     union all
                     select '2020-11' month
                     union all
                     select '2020-12' month
                 ) mid2
                 on mid2.month >= mid.month) mid3
      group by month) mid4
         left join
     (select count(ride_id) accepted_rides, month
      from (select month, mid5.ride_id
            from (select ride_id,
                         if(substring(requested_at, 6, 2) < 10, substring(requested_at, 7, 1),
                            substring(requested_at, 6, 2)) month
                  from Rides
                  where substring(requested_at, 1, 4) = '2020') mid5
                     inner join
                 AcceptedRides on AcceptedRides.ride_id = mid5.ride_id) mid6
      group by month) mid7 on mid7.month = mid4.month;