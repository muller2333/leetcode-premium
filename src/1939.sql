select distinct Confirmations.user_id
from Confirmations
         inner join Confirmations c
                    on c.user_id = Confirmations.user_id
                        and Confirmations.time_stamp < c.time_stamp
where timestampdiff(second, Confirmations.time_stamp, c.time_stamp) <= 86400;