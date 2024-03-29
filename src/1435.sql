select
    ifnull(total, 0) total,
    mid2.bin
from
    (
        select
            count(bin) total,
            bin
        from
            (
                select
                    case
                        when duration < 300 then '[0-5>'
                        when duration < 600 then '[5-10>'
                        when duration < 900 then '[10-15>'
                        else '15 or more'
                    end bin
                from
                    Sessions
            ) mid
        group by
            bin
    ) mid
    right join (
        select
            '[0-5>' bin
        union
        all
        select
            '[5-10>' bin
        union
        all
        select
            '[10-15>' bin
        union
        all
        select
            '15 or more' bin
    ) mid2 on mid2.bin = mid.bin;