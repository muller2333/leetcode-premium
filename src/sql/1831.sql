select
      transaction_id
from
      (
            select
                  transaction_id,
                  rank() over(
                        partition by day
                        order by
                              amount desc
                  ) rk
            from
                  (
                        select
                              transaction_id,
                              substring(day, 1, 10) day,
                              amount
                        from
                              Transactions
                  ) mid
      ) mid2
where
      rk = 1
order by
      transaction_id;