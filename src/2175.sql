select
      mid3.team_id,
      mid2.name name,
      mid3.rownum - mid2.rownum rank_diff
from
      (
            select
                  mid.*,
                  @rownum := @rownum + 1 rownum
            from
                  (
                        select
                              TeamPoints.team_id,
                              points + points_change points,
                              name
                        from
                              TeamPoints
                              inner join PointsChange on TeamPoints.team_id = PointsChange.team_id
                        order by
                              points desc,
                              name
                  ) mid,
                  (
                        select
                              @rownum := 0
                  ) rownum
      ) mid2
      inner join (
            select
                  team_id,
                  name,
                  @rownum2 := @rownum2 + 1 rownum
            from
                  TeamPoints,
                  (
                        select
                              @rownum2 := 0
                  ) rownum2
            order by
                  points desc,
                  name
      ) mid3 on mid2.team_id = mid3.team_id;