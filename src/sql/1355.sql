select
    activity
from
    Friends
group by
    activity
having
    count(name) not in (
        (
            select
                max(cnt) cnt
            from
                (
                    select
                        count(name) cnt
                    from
                        Friends
                    group by
                        activity
                ) mid
            union
            select
                min(cnt) cnt
            from
                (
                    select
                        count(name) cnt
                    from
                        Friends
                    group by
                        activity
                ) mid
        )
    );