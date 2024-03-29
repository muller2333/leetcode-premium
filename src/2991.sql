select
    country,
    w top_winery,
    ifnull(w2, 'No second winery') second_winery,
    ifnull(w3, 'No third winery') third_winery
from
    (
        select
            country,
            w,
            lead(w, 1) over(partition by country) w2,
            lead(w, 2) over(partition by country) w3,
            num
        from
            (
                select
                    country,
                    concat(winery, '(', sum, ')') w,
                    row_number() over(partition by country) num
                from
                    (
                        select
                            country,
                            winery,
                            sum(points) sum
                        from
                            Wineries
                        group by
                            country,
                            winery
                        order by
                            country,
                            sum(points) desc,
                            winery
                    ) mid
            ) mid2
    ) mid3
where
    num = 1;