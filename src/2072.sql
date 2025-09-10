select
    if(
        n_score - c_score = 0,
        'No Winner',
        if(
            n_score - c_score > 0,
            'New York University',
            'California University'
        )
    ) winner
from
    (
        select
            count(score) n_score,
            1 id
        from
            NewYork
        where
            score >= 90
    ) mid
    inner join (
        select
            count(score) c_score,
            1 id
        from
            California
        where
            score >= 90
    ) mid2 on mid2.id = mid.id;