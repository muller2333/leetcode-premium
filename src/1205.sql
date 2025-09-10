select
      mid3.country,
      mid3.month,
      approved_count,
      approved_amount,
      ifnull(chargeback_count, 0) chargeback_count,
      ifnull(chargeback_amount, 0) chargeback_amount
from
      (
            select
                  month,
                  country,
                  count(amount) chargeback_count,
                  sum(amount) chargeback_amount
            from
                  (
                        select
                              country,
                              amount,
                              substring(Chargebacks.trans_date, 1, 7) month
                        from
                              Transactions
                              right join Chargebacks on Chargebacks.trans_id = Transactions.id
                  ) mid
            group by
                  month,
                  country
      ) mid2
      right join (
            select
                  count(amount) approved_count,
                  sum(amount) approved_amount,
                  country,
                  month
            from
                  (
                        select
                              substring(trans_date, 1, 7) month,
                              country,
                              amount
                        from
                              Transactions
                        where
                              state = 'approved'
                  ) mid
            group by
                  country,
                  month
      ) mid3 on mid2.country = mid3.country
      and mid2.month = mid3.month
union
all
select
      mid2.country,
      mid2.month,
      0 approved_count,
      0 approved_amount,
      chargeback_count,
      chargeback_amount
from
      (
            select
                  month,
                  country,
                  count(amount) chargeback_count,
                  sum(amount) chargeback_amount
            from
                  (
                        select
                              country,
                              amount,
                              substring(Chargebacks.trans_date, 1, 7) month
                        from
                              Transactions
                              right join Chargebacks on Chargebacks.trans_id = Transactions.id
                  ) mid
            group by
                  month,
                  country
      ) mid2
      left join (
            select
                  count(amount) approved_count,
                  sum(amount) approved_amount,
                  country,
                  month
            from
                  (
                        select
                              substring(trans_date, 1, 7) month,
                              country,
                              amount
                        from
                              Transactions
                        where
                              state = 'approved'
                  ) mid
            group by
                  country,
                  month
      ) mid3 on mid2.country = mid3.country
      and mid2.month = mid3.month
where
      approved_count is null