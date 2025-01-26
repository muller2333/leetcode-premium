select
    project_id,
    candidate_id,
    score
from
    (
        select
            project_id,
            candidate_id,
            score,
            rank() over(
                partition by project_id
                order by
                    score desc,
                    candidate_id
            ) rk
        from
            (
                select
                    project_id,
                    candidate_id,
                    count(skill) count,
                    cnt,
                    100 + sum(score) score
                from
                    (
                        select
                            project_id,
                            candidate_id,
                            mid.skill,
                            if(
                                proficiency > importance,
                                10,
                                if(proficiency = importance, 0, -5)
                            ) score,
                            cnt
                        from
                            Candidates
                            right join (
                                select
                                    project_id,
                                    skill,
                                    importance,
                                    count(project_id) over(partition by project_id) cnt
                                from
                                    Projects
                            ) mid on mid.skill = Candidates.skill
                        where
                            candidate_id is not null
                    ) mid2
                group by
                    project_id,
                    candidate_id
            ) mid3
        where
            count >= cnt
    ) mid4
where
    rk = 1
order by
    project_id