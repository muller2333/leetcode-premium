SELECT A.player_id,
       A.event_date,
       SUM(A.games_played) OVER (
           PARTITION BY
               A.player_id
           ORDER BY
               A.event_date
           ) AS games_played_so_far
FROM Activity A;

# SELECT player_id,
#        event_date,
#        (SELECT SUM(games_played)
#         FROM Activity
#         WHERE player_id = a.player_id
#           AND event_date <= a.event_date) games_played_so_far
# FROM Activity a;