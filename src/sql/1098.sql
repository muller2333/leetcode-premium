select
    book_id,
    name
from
    Books
where
    book_id not in (
        select
            book_id
        from
            Orders
        where
            date_add(dispatch_date, interval 1 year) > '2019-06-23'
        group by
            book_id
        having
            sum(quantity) >= 10
    )
    and date_add(available_from, interval 1 month) <= '2019-06-23';