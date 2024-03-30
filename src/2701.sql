select
    *
from
    (
        select
            customer_id,
            transaction_date,
            lead(transaction_date, 1) over(
                partition by customer_id
                order by
                    transaction_date,
                    amount
            ) next,
            lead(transaction_date, 2) over(
                partition by customer_id
                order by
                    transaction_date,
                    amount
            ) next2,
            amount,
            lead(amount, 1) over(
                partition by customer_id
                order by
                    transaction_date,
                    amount
            ) amount2,
            lead(amount, 2) over(
                partition by customer_id
                order by
                    transaction_date,
                    amount
            ) amount3
        from
            Transactions
    ) mid
where
    next is not null
    and next2 is not null
    and datediff(next, transaction_date) = 1
    and datediff(next2, transaction_date) = 2
    and amount < amount2
    and amount2 < amount3