select
      distinct mid3.account_id
from
      (
            select
                  month,
                  mid2.account_id,
                  rank() over (
                        partition by account_id
                        order by
                              month
                  ) r
            from
                  (
                        select
                              sum(amount) total,
                              month,
                              account_id
                        from
                              (
                                    select
                                          account_id,
                                          concat(substring(day, 1, 4), substring(day, 6, 2)) month,
                                          amount
                                    from
                                          Transactions
                                    where
                                          type = 'Creditor'
                              ) mid
                        group by
                              month,
                              account_id
                  ) mid2
                  left join Accounts on mid2.account_id = Accounts.account_id
            where
                  total > max_income
      ) mid3
      inner join (
            select
                  month,
                  mid2.account_id,
                  (
                        rank() over (
                              partition by account_id
                              order by
                                    month
                        ) + 1
                  ) r
            from
                  (
                        select
                              sum(amount) total,
                              month,
                              account_id
                        from
                              (
                                    select
                                          transaction_id,
                                          account_id,
                                          concat(substring(day, 1, 4), substring(day, 6, 2)) month,
                                          amount
                                    from
                                          Transactions
                                    where
                                          type = 'Creditor'
                              ) mid
                        group by
                              month,
                              account_id
                  ) mid2
                  left join Accounts on mid2.account_id = Accounts.account_id
            where
                  total > max_income
      ) mid4 on mid3.account_id = mid4.account_id
      and mid3.r = mid4.r
where
      PERIOD_DIFF(mid3.month, mid4.month) = 1
order by
      mid3.account_id;