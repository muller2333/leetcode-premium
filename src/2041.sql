select candidate_id
from Candidates
where years_of_exp >= 2
  and interview_id in (select interview_id from Rounds group by interview_id having sum(score) > 15);