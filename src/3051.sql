select
    candidate_id
from
    Candidates
where
    skill in ('Python', 'Tableau', 'PostgreSQL')
group by
    candidate_id
having
    count(candidate_id) = 3
order by
    candidate_id;