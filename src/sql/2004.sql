select
      'Junior' experience,
      count(experience) - 1 accepted_candidates
from
      (
            select
                  *
            from
                  (
                        select
                              count(diff) cnt,
                              min(diff) remainder
                        from
                              (
                                    select
                                          70000 - total diff
                                    from
                                          (
                                                select
                                                      experience,
                                                      (
                                                            select
                                                                  sum(salary)
                                                            from
                                                                  (
                                                                        select
                                                                              experience,
                                                                              salary,
                                                                              row_number() over (
                                                                                    partition by experience
                                                                                    order by
                                                                                          salary
                                                                              ) r
                                                                        from
                                                                              Candidates
                                                                        where
                                                                              experience = 'Senior'
                                                                  ) mid
                                                            where
                                                                  experience = mid2.experience
                                                                  and r <= mid2.r
                                                      ) total
                                                from
                                                      (
                                                            select
                                                                  experience,
                                                                  salary,
                                                                  row_number() over (
                                                                        partition by experience
                                                                        order by
                                                                              salary
                                                                  ) r
                                                            from
                                                                  Candidates
                                                            where
                                                                  experience = 'Senior'
                                                      ) mid2
                                                union
                                                all
                                                select
                                                      'Senior' experience,
                                                      0 total
                                          ) mid3
                              ) mid4
                        where
                              diff >= 0
                  ) mid5
                  inner join (
                        select
                              experience,
                              (
                                    select
                                          sum(salary)
                                    from
                                          (
                                                select
                                                      experience,
                                                      salary,
                                                      row_number() over (
                                                            partition by experience
                                                            order by
                                                                  salary
                                                      ) r
                                                from
                                                      Candidates
                                                where
                                                      experience = 'Junior'
                                          ) mid
                                    where
                                          experience = mid2.experience
                                          and r <= mid2.r
                              ) total
                        from
                              (
                                    select
                                          experience,
                                          salary,
                                          row_number() over (
                                                partition by experience
                                                order by
                                                      salary
                                          ) r
                                    from
                                          Candidates
                                    where
                                          experience = 'Junior'
                              ) mid2
                        union
                        all
                        select
                              'Junior' experience,
                              0 total
                  ) mid7 on remainder >= total
      ) mid8
group by
      cnt
union
select
      'Senior' experience,
      cnt - 1 accepted_candidates
from
      (
            select
                  *
            from
                  (
                        select
                              count(diff) cnt,
                              min(diff) remainder
                        from
                              (
                                    select
                                          70000 - total diff
                                    from
                                          (
                                                select
                                                      experience,
                                                      (
                                                            select
                                                                  sum(salary)
                                                            from
                                                                  (
                                                                        select
                                                                              experience,
                                                                              salary,
                                                                              row_number() over (
                                                                                    partition by experience
                                                                                    order by
                                                                                          salary
                                                                              ) r
                                                                        from
                                                                              Candidates
                                                                        where
                                                                              experience = 'Senior'
                                                                  ) mid
                                                            where
                                                                  experience = mid2.experience
                                                                  and r <= mid2.r
                                                      ) total
                                                from
                                                      (
                                                            select
                                                                  experience,
                                                                  salary,
                                                                  row_number() over (
                                                                        partition by experience
                                                                        order by
                                                                              salary
                                                                  ) r
                                                            from
                                                                  Candidates
                                                            where
                                                                  experience = 'Senior'
                                                      ) mid2
                                                union
                                                all
                                                select
                                                      'Senior' experience,
                                                      0 total
                                          ) mid3
                              ) mid4
                        where
                              diff >= 0
                  ) mid5
                  inner join (
                        select
                              experience,
                              (
                                    select
                                          sum(salary)
                                    from
                                          (
                                                select
                                                      experience,
                                                      salary,
                                                      row_number() over (
                                                            partition by experience
                                                            order by
                                                                  salary
                                                      ) r
                                                from
                                                      Candidates
                                                where
                                                      experience = 'Junior'
                                          ) mid
                                    where
                                          experience = mid2.experience
                                          and r <= mid2.r
                              ) total
                        from
                              (
                                    select
                                          experience,
                                          salary,
                                          row_number() over (
                                                partition by experience
                                                order by
                                                      salary
                                          ) r
                                    from
                                          Candidates
                                    where
                                          experience = 'Junior'
                              ) mid2
                        union
                        all
                        select
                              'Junior' experience,
                              0 total
                  ) mid7 on remainder >= total
      ) mid8
group by
      cnt;