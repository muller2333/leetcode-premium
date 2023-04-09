select mid2.customer_id
from (
         select substring(max(order_date), 1, 4) - substring(min(order_date), 1, 4) + 1 cnt, customer_id
         from Orders
         group by customer_id) mid
         inner join (
    select customer_id, count(distinct year) total
    from (select customer_id, substring(order_date, 1, 4) year from Orders) mid
    group by customer_id) mid2 on mid.customer_id = mid2.customer_id
where cnt = total
  and mid2.customer_id not in (select distinct mid5.customer_id
                               from (select customer_id, year, sum(price) total
                                     from (select order_id, customer_id, substring(order_date, 1, 4) year, price
                                           from Orders
                                           where customer_id in
                                                 (select mid2.customer_id
                                                  from (
                                                           select substring(max(order_date), 1, 4) -
                                                                  substring(min(order_date), 1, 4) + 1 cnt,
                                                                  customer_id
                                                           from Orders
                                                           group by customer_id) mid
                                                           inner join (
                                                      select customer_id, count(distinct year) total
                                                      from (select customer_id, substring(order_date, 1, 4) year from Orders) mid
                                                      group by customer_id) mid2 on mid.customer_id = mid2.customer_id
                                                  where cnt = total)) mid3
                                     group by customer_id, year) mid5
                                        left join
                                    (
                                        select customer_id, year - 1 year, sum(price) total
                                        from (select order_id, customer_id, substring(order_date, 1, 4) year, price
                                              from Orders
                                              where customer_id in
                                                    (select mid2.customer_id
                                                     from (
                                                              select substring(max(order_date), 1, 4) -
                                                                     substring(min(order_date), 1, 4) + 1 cnt,
                                                                     customer_id
                                                              from Orders
                                                              group by customer_id) mid
                                                              inner join (
                                                         select customer_id, count(distinct year) total
                                                         from (select customer_id, substring(order_date, 1, 4) year from Orders) mid
                                                         group by customer_id) mid2
                                                                         on mid.customer_id = mid2.customer_id
                                                     where cnt = total)) mid3
                                        group by customer_id, year) mid4
                                    on mid4.customer_id = mid5.customer_id and mid4.year = mid5.year
                               where mid4.total is not null
                                 and mid5.total >= mid4.total);