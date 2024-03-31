(
    select
        distinct Coordinates.X X,
        Coordinates.Y Y
    from
        Coordinates
        join Coordinates c on Coordinates.X = c.Y
        and Coordinates.Y = c.x
    where
        Coordinates.X < Coordinates.Y
)
union
select
    X,
    Y
from
    (
        select
            X,
            Y,
            count(X) cnt
        from
            Coordinates
        group by
            X,
            Y
    ) mid
where
    cnt >= 2
    and X = Y
order by
    X,
    Y;