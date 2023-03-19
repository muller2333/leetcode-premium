select Salesperson.salesperson_id, name, ifnull(total, 0) total
from Salesperson
         left join (select salesperson_id, sum(price) total
                    from Customer
                             right join Sales on Sales.customer_id = Customer.customer_id
                    group by salesperson_id) mid on mid.salesperson_id = Salesperson.salesperson_id;