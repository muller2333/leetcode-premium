select
    policy_id,
    mid.state,
    fraud_score
from
    (
        select
            policy_id,
            state,
            fraud_score,
            rank() over(
                partition by state
                order by
                    fraud_score desc
            ) rk
        from
            Fraud
    ) mid
    join (
        select
            ceil(count(policy_id) / 20) cnt,
            state
        from
            Fraud
        group by
            state
    ) mid2 on mid.state = mid2.state
    and mid.rk <= cnt
order by
    state,
    fraud_score desc,
    policy_id;