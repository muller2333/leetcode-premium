select transaction_id
from Transactions
         inner join (select day, max(amount) mamount
                     from (select transaction_id, substring(day, 1, position(' ' in day)) day, amount
                           from Transactions) mid
                     group by day) mid2 on mid2.mamount = Transactions.amount and
                                           substring(Transactions.day, 1, position(' ' in Transactions.day)) = mid2.day
order by transaction_id;