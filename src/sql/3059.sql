select
    email_domain,
    count(email_domain) count
from
    (
        select
            substring(email, position('@' in email) + 1) email_domain
        from
            Emails
    ) mid
where
    position('.com' in email_domain) >= 1
group by
    email_domain
order by
    email_domain;