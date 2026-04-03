select
    customer_id
from
    (
        select
            customer_id,
            rank() over(
                order by
                    cnt desc
            ) rk
        from
            (
                select
                    customer_id,
                    transaction_date,
                    count(transaction_id) cnt
                from
                    (
                        select
                            mid.transaction_id,
                            mid.customer_id,
                            mid.transaction_date
                        from
                            (
                                select
                                    transaction_id,
                                    customer_id,
                                    transaction_date,
                                    row_number() over(
                                        partition by customer_id
                                        order by
                                            transaction_date
                                    ) rn
                                from
                                    Transactions
                            ) mid
                            join (
                                select
                                    transaction_date,
                                    transaction_id,
                                    customer_id,
                                    row_number() over(
                                        partition by customer_id
                                        order by
                                            transaction_date
                                    ) rn
                                from
                                    Transactions
                            ) mid2 on mid.customer_id = mid2.customer_id
                            and mid.transaction_date <= mid2.transaction_date
                            and datediff(mid2.transaction_date, mid.transaction_date) = mid2.rn - mid.rn
                    ) mid3
                group by
                    customer_id,
                    transaction_date
            ) mid4
    ) mid5
where
    rk = 1
order by
    customer_id;