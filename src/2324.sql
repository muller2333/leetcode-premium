# select mid3.user_id, mid2.product_id
# from (select Product.product_id, user_id, sum(quantity * price) total
#       from Sales
#                left join Product on Sales.product_id = Product.product_id
#       group by Product.product_id, user_id) mid2
#          right join
#      (select max(total) total, user_id
#       from (select Product.product_id, user_id, sum(quantity * price) total
#             from Sales
#                      left join Product on Sales.product_id = Product.product_id
#             group by Product.product_id, user_id) mid
#       group by user_id) mid3 on mid2.user_id = mid3.user_id and mid2.total = mid3.total;

select user_id, product_id
from (select user_id, product_id, rank() over (partition by user_id order by total desc) r
      from (select Product.product_id, user_id, sum(quantity * price) total
            from Sales
                     left join Product on Sales.product_id = Product.product_id
            group by Product.product_id, user_id) mid) mid2
where r = 1;