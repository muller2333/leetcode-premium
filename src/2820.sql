select
    candidate
from
    (
        select
            candidate,
            dense_rank() over(
                order by
                    cnt desc
            ) rk
        from
            (
                select
                    sum(cnt) cnt,
                    candidate
                from
                    Votes
                    right join (
                        select
                            voter,
                            1 / count(candidate) cnt
                        from
                            Votes
                        where
                            candidate is not null
                        group by
                            voter
                    ) mid on mid.voter = Votes.voter
                group by
                    candidate
                order by
                    cnt desc,
                    candidate
            ) mid2
    ) mid3
where
    rk = 1
order by
    candidate;