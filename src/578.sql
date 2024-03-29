select
    mid.question_id survey_log
from
    (
        select
            question_id,
            count(q_num) cnt
        from
            SurveyLog
        where
            action = 'show'
        group by
            question_id
    ) mid
    left join (
        select
            question_id,
            count(q_num) cnt
        from
            SurveyLog
        where
            action = 'answer'
        group by
            question_id
    ) mid2 on mid.question_id = mid2.question_id
order by
    ifnull(mid2.cnt, 0) / mid.cnt desc,
    mid.question_id asc
limit
    1;