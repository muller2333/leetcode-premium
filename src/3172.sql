select
    user_id
from
    emails
    right join (
        select
            email_id,
            action_date
        from
            texts
        where
            signup_action = 'Verified'
    ) mid on mid.email_id = emails.email_id
where
    datediff(action_date, signup_date) = 1
order by
    user_id