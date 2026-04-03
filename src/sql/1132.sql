select
  round(avg(percentage), 2) average_daily_percent
from
  (
    select
      round(100 * mid3.total / mid4.total, 2) percentage,
      mid3.action_date
    from
      (
        select
          action_date,
          sum(if(mid2.post_id is not null, 1, 0)) total
        from
          (
            select
              distinct action_date,
              post_id
            from
              Actions
            where
              action = 'report'
              and extra = 'spam'
          ) mid
          left join (
            select
              post_id
            from
              Removals
          ) mid2 on mid.post_id = mid2.post_id
        group by
          action_date
      ) mid3
      inner join (
        select
          action_date,
          count(distinct post_id) total
        from
          Actions
        where
          action = 'report'
          and extra = 'spam'
        group by
          action_date
      ) mid4 on mid3.action_date = mid4.action_date
  ) mid5;