select
  session_id
from
  Playback
where
  session_id not in (
    select
      distinct session_id
    from
      Playback
      left join Ads on Playback.customer_id = Ads.customer_id
    where
      timestamp <= end_time
      and timestamp >= start_time
  );