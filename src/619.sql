select
    if(count(mid.num), max(mid.num), null) num
from
    (
        select
            num
        from
            MyNumbers
        group by
            num
        having
            count(num) = 1
    ) mid;