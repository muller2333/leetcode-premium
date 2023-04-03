select account_id,
       day,
       (select sum(amount)
        from (select account_id, day, if(type = 'Deposit', amount, -amount) amount from Transactions) mid
        where account_id = t.account_id
          and day <= t.day) balance
from (select account_id, day, if(type = 'Deposit', amount, -amount) amount from Transactions) t
order by account_id, day;