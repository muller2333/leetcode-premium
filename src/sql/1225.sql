select
  state period_state,
  min(d) start_date,
  max(d) end_date
from
  (
    select
      d,
      mid3.state,
      if(next_date is null, max_date, next_date) next_date
    from
      (
        select
          d,
          state,
          (
            select
              d
            from
              (
                select
                  fail_date d,
                  'failed' state
                from
                  Failed
                where
                  fail_date >= '2019-01-01'
                  and fail_date <= '2019-12-31'
                union
                all
                select
                  success_date d,
                  'succeeded' state
                from
                  Succeeded
                where
                  success_date >= '2019-01-01'
                  and success_date <= '2019-12-31'
                order by
                  d
              ) mid2
            where
              d > mid.d
              and state != mid.state
            order by
              d
            limit
              1
          ) next_date
        from
          (
            select
              fail_date d,
              'failed' state
            from
              Failed
            where
              fail_date >= '2019-01-01'
              and fail_date <= '2019-12-31'
            union
            all
            select
              success_date d,
              'succeeded' state
            from
              Succeeded
            where
              success_date >= '2019-01-01'
              and success_date <= '2019-12-31'
            order by
              d
          ) mid
      ) mid3
      inner join (
        select
          max(fail_date) max_date,
          'failed' state
        from
          Failed
        where
          fail_date >= '2019-01-01'
          and fail_date <= '2019-12-31'
        union
        all
        select
          max(success_date) max_date,
          'succeeded' state
        from
          Succeeded
        where
          success_date >= '2019-01-01'
          and success_date <= '2019-12-31'
      ) mid4 on mid4.state = mid3.state
  ) mid5
group by
  next_date,
  state
order by
  start_date;