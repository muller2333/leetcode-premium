select country_name,
       case
           when state >= 25 then 'Hot'
           when state <= 15 then 'Cold'
           else 'Warm'
       end
       weather_type
#        if(state >= 25, 'Hot', if(state <= 15, 'Cold', 'Warm')) weather_type
from (select country_id, sum(weather_state) / count(weather_state) state
      from Weather
      where substring(day, 1, 7) = '2019-11'
      group by country_id) mid
         left join Countries
                   on Countries.country_id = mid.country_id;
