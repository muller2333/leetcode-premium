select name
from Candidate
where id = (select candidateId
            from (select candidateId, count(id) cnt from Vote group by candidateId) mid
            order by cnt desc
            limit 1);