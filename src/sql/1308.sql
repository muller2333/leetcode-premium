SELECT
    s.gender,
    s.day,
    SUM(s.score_points) OVER (
        PARTITION BY s.gender
        ORDER BY
            s.day
    ) AS total
FROM
    Scores s;

-- SELECT
--     gender,
--     day,
--     (
--         SELECT
--             SUM(score_points)
--         FROM
--             Scores
--         WHERE
--             gender = 'F'
--             AND day <= s.day
--     ) total
-- FROM
--     Scores s
-- where
--     gender = 'F'
-- union
-- all
-- SELECT
--     gender,
--     day,
--     (
--         SELECT
--             SUM(score_points)
--         FROM
--             Scores
--         WHERE
--             gender = 'M'
--             AND day <= s.day
--     ) total
-- FROM
--     Scores s
-- where
--     gender = 'M'
-- order by
--     gender,
--     day;