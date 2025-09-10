select
     id,
     ifnull(drink, newDrink) drink
from
     (
          select
               id,
               (
                    select
                         drink
                    from
                         (
                              select
                                   id,
                                   drink,
                                   @rownum2 := @rownum2 + 1 rownum
                              from
                                   CoffeeShop,
                                   (
                                        select
                                             @rownum2 := 0
                                   ) rownum
                         ) mid2
                    where
                         rownum < mid.rownum
                         and drink is not null
                    order by
                         rownum desc
                    limit
                         1
               ) newDrink, rownum
          from
               (
                    select
                         id,
                         drink,
                         @rownum := @rownum + 1 rownum
                    from
                         CoffeeShop,
                         (
                              select
                                   @rownum := 0
                         ) rownum
               ) mid
     ) mid3
     inner join (
          select
               drink,
               @rownum3 := @rownum3 + 1 rownum
          from
               CoffeeShop,
               (
                    select
                         @rownum3 := 0
               ) rownum
     ) mid4 on mid4.rownum = mid3.rownum;