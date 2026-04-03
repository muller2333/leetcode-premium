select
    mid5.age_bucket,
    round(send /(open + send) * 100, 2) send_perc,
    round(open /(open + send) * 100, 2) open_perc
from
    (
        select
            sum(open) open,
            age_bucket,
            user_id
        from
            (
                select
                    Age.user_id,
                    ifnull(total, 0) open,
                    age_bucket
                from
                    Age
                    left join (
                        select
                            user_id,
                            sum(time_spent) total,
                            activity_type
                        from
                            (
                                select
                                    *
                                from
                                    Activities
                                where
                                    activity_type = 'open'
                            ) mid6
                        group by
                            user_id
                    ) mid on mid.user_id = Age.user_id
            ) mid3
        group by
            age_bucket
    ) mid5
    join (
        select
            sum(send) send,
            age_bucket,
            user_id
        from
            (
                select
                    Age.user_id,
                    ifnull(total, 0) send,
                    age_bucket
                from
                    Age
                    left join (
                        select
                            user_id,
                            sum(time_spent) total,
                            activity_type
                        from
                            (
                                select
                                    *
                                from
                                    Activities
                                where
                                    activity_type = 'send'
                            ) mid6
                        group by
                            user_id
                    ) mid on mid.user_id = Age.user_id
            ) mid3
        group by
            age_bucket
    ) mid7 on mid5.age_bucket = mid7.age_bucket;