select count(account_id) accounts_count
from Subscriptions
where ((start_date >= '2021-01-01' and start_date <= '2021-12-31') or
       (end_date >= '2021-01-01' and end_date <= '2021-12-31'))
  and account_id not in
      (select account_id from Streams where stream_date <= '2021-12-31' and stream_date >= '2021-01-01');