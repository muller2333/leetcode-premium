select
      id,
      mid4.company,
      salary
from
      (
            select
                  distinct company,
                  ceil,
                  floor
            from
                  (
                        select
                              company,
                              ceil((max + min) / 2) ceil,
                              floor((max + min) / 2) floor
                        from
                              (
                                    select
                                          company,
                                          max(rownum) max,
                                          min(rownum) min
                                    from
                                          (
                                                select
                                                      company,
                                                      @rownum := @rownum + 1 rownum
                                                from
                                                      Employee,
                                                      (
                                                            select
                                                                  @rownum := 0
                                                      ) rownum
                                                order by
                                                      company,
                                                      salary
                                          ) mid
                                    group by
                                          company
                                    union
                                    all
                                    select
                                          company,
                                          max(rownum2) max,
                                          min(rownum2) min
                                    from
                                          (
                                                select
                                                      company,
                                                      @rownum2 := @rownum2 + 1 rownum2
                                                from
                                                      Employee,
                                                      (
                                                            select
                                                                  @rownum2 := 0
                                                      ) rownum
                                                order by
                                                      company,
                                                      salary
                                          ) mid
                                    group by
                                          company
                              ) mid2
                  ) mid3
      ) mid4
      left join (
            select
                  id,
                  salary,
                  company,
                  @rownum3 := @rownum3 + 1 rownum
            from
                  Employee,
                  (
                        select
                              @rownum3 := 0
                  ) rownum3
            order by
                  company,
                  salary
      ) mid5 on mid4.company = mid5.company
      and (
            ceil = rownum
            or floor = rownum
      );