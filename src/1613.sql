with recursive tmp(ids) as (
    select 1
    union
    select ids + 1
    from tmp
    where ids < (select max(customer_id) from Customers)
)
select ids
from tmp
where ids not in (select customer_id from Customers);