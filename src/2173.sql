select mid7.player_id, ifnull(diff, 0) longest_streak
from (
         select player_id, max(diff) diff
         from (select mid3.player_id, if(next_r is null, cnt - r, next_r - r) diff
               from (
                        select player_id,
                               result,
                               r,
                               (select r
                                from (select player_id,
                                             result,
                                             row_number() over (partition by player_id order by match_day ) r
                                      from Matches) mid2
                                where player_id = mid.player_id
                                  and r > mid.r
                                  and result != 'Win'
                                order by r asc
                                limit 1) next_r
                        from (select player_id, result, row_number() over (partition by player_id order by match_day ) r
                              from Matches) mid
                        where result = 'Win'
                    ) mid3
                        left join (select player_id, count(match_day) + 1 cnt from Matches group by player_id) mid4
                                  on mid3.player_id = mid4.player_id) mid5
         group by player_id
     ) mid6
         right join (select distinct player_id from Matches) mid7 on mid6.player_id = mid7.player_id;