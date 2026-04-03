select
     min(log_id) start_id,
     next_id end_id
from
     (
          select
               log_id,
               min(next_id) next_id
          from
               (
                    select
                         Logs.log_id,
                         next_id
                    from
                         Logs
                         left join (
                              select
                                   log_id,
                                   next_id
                              from
                                   (
                                        select
                                             log_id,
                                             if(log_id + 1 = next_id, null, log_id) next_id
                                        from
                                             (
                                                  select
                                                       log_id,
                                                       (
                                                            select
                                                                 log_id
                                                            from
                                                                 Logs
                                                            where
                                                                 log_id > l.log_id
                                                            order by
                                                                 log_id
                                                            limit
                                                                 1
                                                       ) next_id
                                                  from
                                                       Logs l
                                             ) mid
                                   ) mid2
                              where
                                   next_id is not null
                         ) mid3 on Logs.log_id <= mid3.next_id
               ) mid4
          group by
               log_id
     ) mid5
group by
     next_id;