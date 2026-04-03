select
    fuel_type,
    driver_id,
    rating,
    distance
from
    (
        select
            fuel_type,
            driver_id,
            rating,
            distance,
            dense_rank() over(
                partition by fuel_type
                order by
                    rating desc,
                    distance desc,
                    accidents
            ) rk
        from
            (
                select
                    fuel_type,
                    mid2.driver_id,
                    rating,
                    distance,
                    accidents
                from
                    Drivers
                    right join (
                        select
                            fuel_type,
                            driver_id,
                            round(avg(rating), 2) rating,
                            sum(distance) distance
                        from
                            (
                                select
                                    Trips.vehicle_id,
                                    driver_id,
                                    fuel_type,
                                    distance,
                                    rating
                                from
                                    Trips
                                    left join Vehicles on Vehicles.vehicle_id = Trips.vehicle_id
                            ) mid
                        group by
                            fuel_type,
                            driver_id
                    ) mid2 on Drivers.driver_id = mid2.driver_id
            ) mid3
    ) mid4
where
    rk = 1
order by
    fuel_type