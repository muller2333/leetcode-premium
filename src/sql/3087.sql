select
    hashtag,
    hashtag_count
from
    (
        select
            hashtag,
            hashtag_count,
            row_number() over(
                order by
                    hashtag_count desc,
                    hashtag desc
            ) rn
        from
            (
                select
                    sub hashtag,
                    count(sub) hashtag_count
                from
                    (
                        select
                            if(
                                position(' ' in sub) > 1,
                                substring(sub, 1, position(' ' in sub)),
                                sub
                            ) sub
                        from
                            (
                                select
                                    substring(tweet, position('#' in tweet)) sub
                                from
                                    Tweets
                            ) mid
                    ) mid2
                group by
                    sub
            ) mid3
    ) mid4
where
    rn <= 3;