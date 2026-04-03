select
       mid6.spend_date,
       mid6.platform,
       ifnull(total_amount, 0) total_amount,
       ifnull(total_users, 0) total_users
from
       (
              select
                     mid3.spend_date,
                     mid4.platform,
                     sum(total_amount) total_amount,
                     total_users
              from
                     (
                            select
                                   spend_date,
                                   if(cnt = 2, 'both', platform) platform,
                                   total_amount
                            from
                                   (
                                          select
                                                 count(distinct platform) cnt,
                                                 max(platform) platform,
                                                 sum(amount) total_amount,
                                                 spend_date
                                          from
                                                 Spending
                                          group by
                                                 spend_date,
                                                 user_id
                                   ) mid
                     ) mid3
                     inner join (
                            select
                                   count(spend_date) total_users,
                                   spend_date,
                                   platform
                            from
                                   (
                                          select
                                                 spend_date,
                                                 if(cnt = 2, 'both', platform) platform
                                          from
                                                 (
                                                        select
                                                               count(distinct platform) cnt,
                                                               max(platform) platform,
                                                               spend_date
                                                        from
                                                               Spending
                                                        group by
                                                               spend_date,
                                                               user_id
                                                 ) mid
                                   ) mid2
                            group by
                                   spend_date,
                                   platform
                     ) mid4 on mid3.spend_date = mid4.spend_date
                     and mid3.platform = mid4.platform
              group by
                     mid3.spend_date,
                     mid4.platform,
                     total_users
       ) mid5
       right join (
              select
                     spend_date,
                     platform
              from
                     (
                            select
                                   distinct spend_date
                            from
                                   Spending
                     ) mid8
                     inner join (
                            select
                                   'desktop' platform
                            union
                            all
                            select
                                   'mobile' platform
                            union
                            all
                            select
                                   'both' platform
                     ) mid7
       ) mid6 on mid5.platform = mid6.platform
       and mid5.spend_date = mid6.spend_date;