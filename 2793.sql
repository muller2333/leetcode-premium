select
    passenger_id,
    if(rn <= capacity, 'Confirmed', 'Waitlist') Status
from
    Flights
    right join (
        select
            passenger_id,
            flight_id,
            row_number() over(
                partition by flight_id
                order by
                    booking_time
            ) rn
        from
            Passengers
    ) mid on mid.flight_id = Flights.flight_id
order by
    passenger_id;