select
    sub_id post_id,
    ifnull(cnt, 0) number_of_comments
from
    (
        select
            distinct sub_id
        from
            Submissions
        where
            parent_id is null
    ) mid
    left join (
        select
            parent_id,
            count(distinct sub_id) cnt
        from
            Submissions
        group by
            parent_id
        having
            parent_id is not null
    ) mid2 on mid.sub_id = mid2.parent_id
order by
    post_id;