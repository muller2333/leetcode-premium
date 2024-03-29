select
  mid.seat_id
from
  (
    select
      seat_id,
      free
    from
      Cinema c
  ) mid
  inner join (
    select
      seat_id - 1 seat_id,
      free
    from
      Cinema c
  ) mid2 on mid2.seat_id = mid.seat_id
where
  mid.free = 1
  and mid2.free = 1
union
select
  mid.seat_id + 1 seat_id
from
  (
    select
      seat_id,
      free
    from
      Cinema c
  ) mid
  inner join (
    select
      seat_id - 1 seat_id,
      free
    from
      Cinema c
  ) mid2 on mid2.seat_id = mid.seat_id
where
  mid.free = 1
  and mid2.free = 1
order by
  seat_id;