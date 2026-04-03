select
    bike_number,
    max(end_time) end_time
from
    Bikes
group by
    bike_number
order by
    end_time desc;