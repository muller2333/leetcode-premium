select
     username,
     activity,
     startDate,
     endDate
from
     UserActivity
where
     username in (
          select
               username
          from
               UserActivity
          group by
               username
          having
               count(username) = 1
     )
union
all
select
     mid2.username,
     activity,
     startDate,
     mid2.endDate
from
     UserActivity
     right join (
          select
               mid.username,
               max(UserActivity.endDate) endDate
          from
               UserActivity
               right join(
                    select
                         username,
                         max(endDate) endDate
                    from
                         UserActivity
                    group by
                         username
                    having
                         count(username) > 1
               ) mid on mid.username = UserActivity.username
               and UserActivity.endDate < mid.endDate
          group by
               mid.username
     ) mid2 on mid2.username = UserActivity.username
     and mid2.endDate = UserActivity.endDate;