select
       item_category CATEGORY,
       sum(Monday) MONDAY,
       sum(Tuesday) TUESDAY,
       sum(Wednesday) WEDNESDAY,
       sum(Thursday) THURSDAY,
       sum(Friday) FRIDAY,
       sum(Saturday) SATURDAY,
       sum(Sunday) SUNDAY
from
       (
              select
                     item_category,
                     if(day = Monday, total, 0) Monday,
                     if(day = Tuesday, total, 0) Tuesday,
                     if(day = Wednesday, total, 0) Wednesday,
                     if(day = Thursday, total, 0) Thursday,
                     if(day = Friday, total, 0) Friday,
                     if(day = Saturday, total, 0) Saturday,
                     if(day = Sunday, total, 0) Sunday
              from
                     (
                            select
                                   case
                                          day
                                          when 1 then 'Sunday'
                                          when 2 then 'Monday'
                                          when 3 then 'Tuesday'
                                          when 4 then 'Wednesday'
                                          when 5 then 'Thursday'
                                          when 6 then 'Friday'
                                          else 'Saturday'
                                   end day,
                                   item_category,
                                   total
                            from
                                   (
                                          select
                                                 dayofweek(order_date) day,
                                                 item_category,
                                                 sum(quantity) total
                                          from
                                                 Orders
                                                 left join Items on Items.item_id = Orders.item_id
                                          group by
                                                 dayofweek(order_date),
                                                 item_category
                                   ) mid
                     ) mid2,
                     (
                            select
                                   'Monday' Monday,
                                   'Tuesday' Tuesday,
                                   'Wednesday' Wednesday,
                                   'Thursday' Thursday,
                                   'Friday' Friday,
                                   'Saturday' Saturday,
                                   'Sunday' Sunday
                            from
                                   Items
                            limit
                                   1
                     ) mid3
       ) mid4
group by
       item_category
union
select
       item_category Category,
       0 MONDAY,
       0 TUESDAY,
       0 WEDNESDAY,
       0 THURSDAY,
       0 FRIDAY,
       0 SATURDAY,
       0 SUNDAY
from
       Items
where
       item_category not in (
              select
                     distinct item_category
              from
                     Orders
                     left join Items on Orders.item_id = Items.item_id
       )
order by
       Category;