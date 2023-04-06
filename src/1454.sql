select id, name
from Accounts
where id in (select distinct mid.id
             from (select distinct id,
                                   date_add(login_date, interval -4 day)                        login_date,
                                   dense_rank() over (partition by id order by login_date desc) r
                   from Logins
                   where id in (select id from Logins group by id having count(distinct login_date) >= 5)) mid
                      inner join
                  (select distinct id, login_date, dense_rank() over (partition by id order by login_date desc) r
                   from Logins
                   where id in (select id from Logins group by id having count(distinct login_date) >= 5)) mid2
                  on mid.login_date = mid2.login_date and
                     mid.id = mid2.id
             where mid.r + 4 = mid2.r)
order by id;