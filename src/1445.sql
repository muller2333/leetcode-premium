select mid.sale_date, apple_num - orange_num diff
from (select sale_date, sold_num apple_num from Sales where fruit = 'apples') mid
         inner join
     (select sale_date, sold_num orange_num from Sales where fruit = 'oranges') mid2
     on mid2.sale_date = mid.sale_date;


# select mid5.sale_date, (apple_num - orange_num) diff
# from (select ifnull(sold_num, 0) apple_num, mid4.sale_date sale_date
#       from (select sale_date, sold_num from Sales where fruit = 'apples') mid3
#                right join (select distinct sale_date from Sales) mid4 on mid3.sale_date = mid4.sale_date) mid5
#          inner join
#      (select ifnull(sold_num, 0) orange_num, mid2.sale_date sale_date
#       from (select sale_date, sold_num from Sales where fruit = 'oranges') mid
#                right join (select distinct sale_date from Sales) mid2 on mid.sale_date = mid2.sale_date) mid6
#      on mid5.sale_date = mid6.sale_date;