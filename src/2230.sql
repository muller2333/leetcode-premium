CREATE PROCEDURE getUserIDs(startDate DATE, endDate DATE, minAmount INT) BEGIN
select
  distinct user_id
from
  Purchases
where
  time_stamp >= startDate
  and time_stamp <= endDate
  and amount >= minAmount
order by
  user_id;

END