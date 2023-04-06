select name, mail
from Users
where user_id in (select distinct mid2.user_id
                  from (select user_id, contest_id, rank() over (partition by user_id order by contest_id) r
                        from (select contest_id, gold_medal user_id
                              from Contests
                              union all
                              select contest_id, silver_medal user_id
                              from Contests
                              union all
                              select contest_id, bronze_medal user_id
                              from Contests) mid) mid2
                           inner join
                       (select user_id, contest_id, (rank() over (partition by user_id order by contest_id) + 2) r
                        from (select contest_id, gold_medal user_id
                              from Contests
                              union all
                              select contest_id, silver_medal user_id
                              from Contests
                              union all
                              select contest_id, bronze_medal user_id
                              from Contests) mid) mid3
                       on mid2.user_id = mid3.user_id and mid2.r = mid3.r
                  where mid2.contest_id = mid3.contest_id + 2
                  union
                  select gold_medal user_id
                  from Contests
                  group by gold_medal
                  having count(contest_id) >= 3);