SELECT product_id,
       MAX(CASE WHEN store = 'store1' THEN price END) AS store1,
       MAX(CASE WHEN store = 'store2' THEN price END) AS store2,
       MAX(CASE WHEN store = 'store3' THEN price END) AS store3
FROM Products
GROUP BY product_id;

# select mid5.product_id, store1, store2, store3
# from (select mid3.product_id, store1, store2
#       from (select mid.product_id, price store1
#             from (select distinct product_id from Products) mid
#                      left join (select product_id, price from Products where store = 'store1') mid2
#                                on mid2.product_id = mid.product_id) mid3
#                inner join
#            (select mid.product_id, price store2
#             from (select distinct product_id from Products) mid
#                      left join (select product_id, price from Products where store = 'store2') mid2
#                                on mid2.product_id = mid.product_id) mid4
#            on mid3.product_id = mid4.product_id) mid5
#          inner join
#      (select mid.product_id, price store3
#       from (select distinct product_id from Products) mid
#                left join (select product_id, price from Products where store = 'store3') mid2
#                          on mid2.product_id = mid.product_id) mid6
#      on mid5.product_id = mid6.product_id;