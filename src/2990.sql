select
    user_id
from
    Loans
where
    loan_type = 'Refinance'
    or loan_type = 'Mortgage'
group by
    user_id
having
    count(distinct loan_type) >= 2
order by
    user_id;