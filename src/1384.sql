select mid3.product_id, product_name, report_year, total_amount
from Product
         right join (select product_id,
                            (datediff(start_date, end_date) + 1) * average_daily_sales total_amount,
                            substring(start_date, 1, 4)                                report_year
                     from (select Sales.product_id,
                                  if(Sales.period_end <= mid.period_end, Sales.period_end, mid.period_end) start_date,
                                  if(Sales.period_start >= mid.period_start, Sales.period_start,mid.period_start) end_date,
                                  average_daily_sales
                           from Sales
                                    right join
                                (select '2018-01-01' period_start, '2018-12-31' period_end
                                 union
                                 select '2019-01-01' period_start, '2019-12-31' period_end
                                 union
                                 select '2020-01-01' period_start, '2020-12-31' period_end) mid
                                on Sales.period_end >= mid.period_start
                           where Sales.period_start <= mid.period_end) mid2) mid3
                    on mid3.product_id = Product.product_id
order by product_id, report_year;