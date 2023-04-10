select mid4.month, round(100 * if(mid4.cnt = 0, 0, ifnull(mid2.cnt, 0) / mid4.cnt), 2) working_percentage
from (select substring(join_date, 6, 2) / 1 month, cnt
      from (select mid.join_date, count(*) cnt
            from Drivers
                     right join (select '2020-01-31' join_date
                                 union all
                                 select '2020-02-29' join_date
                                 union all
                                 select '2020-03-31' join_date
                                 union all
                                 select '2020-04-30' join_date
                                 union all
                                 select '2020-05-31' join_date
                                 union all
                                 select '2020-06-30' join_date
                                 union all
                                 select '2020-07-31' join_date
                                 union all
                                 select '2020-08-31' join_date
                                 union all
                                 select '2020-09-30' join_date
                                 union all
                                 select '2020-10-31' join_date
                                 union all
                                 select '2020-11-30' join_date
                                 union all
                                 select '2020-12-31' join_date) mid on mid.join_date >= Drivers.join_date
            group by mid.join_date) mid3) mid4
         left join
     (select count(distinct AcceptedRides.driver_id) cnt, month
      from (select ride_id, substring(requested_at, 6, 2) / 1 month
            from Rides
            where substring(requested_at, 1, 4) = '2020') mid
               inner join AcceptedRides on AcceptedRides.ride_id = mid.ride_id
      group by month) mid2 on mid2.month = mid4.month;