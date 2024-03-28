select
    city
from
    Listings
group by
    city
having
    sum(price) / count(listing_id) > (
        select
            avg(price)
        from
            Listings
    )
order by
    city;