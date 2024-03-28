select
    max(sum_score) - min(sum_score) difference_in_score
from
    (
        select
            assignment1 + assignment2 + assignment3 sum_score
        from
            Scores
    ) mid;