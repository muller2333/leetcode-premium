select distinct mid3.caller_id user_id
from (select *
      from (select caller_id,
                   recipient_id,
                   call_time,
                   call_day,
                   rank() over
                       (partition by caller_id,call_day order by call_time) r
            from (select caller_id, recipient_id, call_time, substring(call_time, 1, 10) call_day
                  from Calls
                  union all
                  select recipient_id caller_id, caller_id recipient_id, call_time, substring(call_time, 1, 10) call_day
                  from Calls) mid) mid2
      where r = 1) mid3
         inner join
     (select *
      from (select caller_id,
                   recipient_id,
                   call_time,
                   call_day,
                   rank() over
                       (partition by caller_id,call_day order by call_time desc) r
            from (select caller_id, recipient_id, call_time, substring(call_time, 1, 10) call_day
                  from Calls
                  union all
                  select recipient_id caller_id, caller_id recipient_id, call_time, substring(call_time, 1, 10) call_day
                  from Calls) mid) mid2
      where r = 1) mid4
     on mid3.call_day = mid4.call_day and mid3.caller_id = mid4.caller_id and mid3.recipient_id = mid4.recipient_id;