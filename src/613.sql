select
      min(diff) shortest
from
      (
            select
                  (mid3.x - mid4.x) diff
            from
                  (
                        select
                              x,
                              @rownum := @rownum + 1 rownum
                        from
                              (
                                    select
                                          x
                                    from
                                          Point
                                    order by
                                          x
                              ) mid,
                              (
                                    select
                                          @rownum := 0
                              ) rn
                  ) mid3
                  inner join (
                        select
                              x,
                              @rownum2 := @rownum2 + 1 rownum2
                        from
                              (
                                    select
                                          x
                                    from
                                          Point
                                    order by
                                          x
                              ) mid2,
                              (
                                    select
                                          @rownum2 := 1
                              ) rn2
                  ) mid4 on mid3.rownum = mid4.rownum2
      ) mid5;