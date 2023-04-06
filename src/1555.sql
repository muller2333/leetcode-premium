select user_id, user_name, credit, if(credit < 0, 'Yes', 'No') credit_limit_breached
from (select Users.user_id, user_name, credit + ifnull(diff, 0) credit
      from Users
               left join (select sum(diff) diff, user_id
                          from (select -amount diff, paid_by user_id
                                from Transactions
                                union all
                                select amount diff, paid_to user_id
                                from Transactions) mid
                          group by user_id) mid2 on mid2.user_id = Users.user_id) mid3;