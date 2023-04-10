select month,
       (select round(avg(total_distance), 2)
        from (select ifnull(total_distance, 0) total_distance, ifnull(total_duration, 0) total_duration, mid3.month
              from (select sum(ride_distance) total_distance, sum(ride_duration) total_duration, month
                    from (select ride_id, substring(requested_at, 6, 2) / 1 month
                          from Rides
                          where substring(requested_at, 1, 4) = '2020') mid
                             inner join AcceptedRides on mid.ride_id = AcceptedRides.ride_id
                    group by month) mid2
                       right join (
                  select 1 month
                  union all
                  select 2 month
                  union all
                  select 3 month
                  union all
                  select 4 month
                  union all
                  select 5 month
                  union all
                  select 6 month
                  union all
                  select 7 month
                  union all
                  select 8 month
                  union all
                  select 9 month
                  union all
                  select 10 month
                  union all
                  select 11 month
                  union all
                  select 12 month
              ) mid3 on mid3.month = mid2.month) mid5
        where month >= mid4.month
          and month <= mid4.month + 2) average_ride_distance,
       (select round(avg(total_duration), 2)
        from (select ifnull(total_distance, 0) total_distance, ifnull(total_duration, 0) total_duration, mid3.month
              from (select sum(ride_distance) total_distance, sum(ride_duration) total_duration, month
                    from (select ride_id, substring(requested_at, 6, 2) / 1 month
                          from Rides
                          where substring(requested_at, 1, 4) = '2020') mid
                             inner join AcceptedRides on mid.ride_id = AcceptedRides.ride_id
                    group by month) mid2
                       right join (
                  select 1 month
                  union all
                  select 2 month
                  union all
                  select 3 month
                  union all
                  select 4 month
                  union all
                  select 5 month
                  union all
                  select 6 month
                  union all
                  select 7 month
                  union all
                  select 8 month
                  union all
                  select 9 month
                  union all
                  select 10 month
                  union all
                  select 11 month
                  union all
                  select 12 month
              ) mid3 on mid3.month = mid2.month) mid5
        where month >= mid4.month
          and month <= mid4.month + 2) average_ride_duration
from (select ifnull(total_distance, 0) total_distance, ifnull(total_duration, 0) total_duration, mid3.month
      from (select sum(ride_distance) total_distance, sum(ride_duration) total_duration, month
            from (select ride_id, substring(requested_at, 6, 2) / 1 month
                  from Rides
                  where substring(requested_at, 1, 4) = '2020') mid
                     inner join AcceptedRides on mid.ride_id = AcceptedRides.ride_id
            group by month) mid2
               right join (
          select 1 month
          union all
          select 2 month
          union all
          select 3 month
          union all
          select 4 month
          union all
          select 5 month
          union all
          select 6 month
          union all
          select 7 month
          union all
          select 8 month
          union all
          select 9 month
          union all
          select 10 month
          union all
          select 11 month
          union all
          select 12 month
      ) mid3 on mid3.month = mid2.month) mid4
where month <= 10
order by month;