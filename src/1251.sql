select mid2.product_id, round(total / counts, 2) average_price
from (select sum(total_price) total, product_id
      from (select Prices.product_id product_id, price * units total_price
            from Prices
                     inner join UnitsSold on Prices.product_id = UnitsSold.product_id
            where purchase_date <= end_date
              and purchase_date >= start_date) mid
      group by product_id) mid2
         inner join (select sum(units) counts, product_id from UnitsSold group by product_id) mid3
                    on mid2.product_id = mid3.product_id