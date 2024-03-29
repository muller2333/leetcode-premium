select
    Flights.flight_id,
    if(
        mid.flight_id is null,
        0,
        if(capacity >= cnt, cnt, capacity)
    ) booked_cnt,
    if(
        mid.flight_id is null,
        0,
        if(cnt <= capacity, 0, cnt - capacity)
    ) waitlist_cnt
from
    Flights
    left join (
        select
            count(passenger_id) cnt,
            flight_id
        from
            Passengers
        group by
            flight_id
    ) mid on mid.flight_id = Flights.flight_id
order by
    flight_id;