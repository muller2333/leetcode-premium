select n transactions_count, ifnull(visits_count, 0) visits_count
from (select ifnull(cnt, 0) transactions_count, count(Visits.user_id) visits_count
      from Visits
               left join (select user_id, transaction_date, count(amount) cnt
                          from Transactions
                          group by user_id, transaction_date) mid
                         on Visits.user_id = mid.user_id and Visits.visit_date = mid.transaction_date
      group by cnt) mid4
         right join
     (with recursive cte_count (n)
                         AS (
             select 0
             union all
             select n + 1
             from cte_count
             where n < (select max(transactions_count)
                        from (select ifnull(cnt, 0) transactions_count
                              from Visits
                                       left join (select user_id, transaction_date, count(amount) cnt
                                                  from Transactions
                                                  group by user_id, transaction_date) mid
                                                 on Visits.user_id = mid.user_id and
                                                    Visits.visit_date = mid.transaction_date
                              group by cnt) mid2)
         )
      select n
      from cte_count) mid3 on mid3.n = mid4.transactions_count;