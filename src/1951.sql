select
      substring(pair, 1, position(',' in pair) - 1) / 1 user1_id,
      substring(pair, position(',' in pair) + 1) / 1 user2_id
from
      (
            select
                  pair,
                  rank() over (
                        order by
                              cnt desc
                  ) r
            from
                  (
                        select
                              count(pair) cnt,
                              pair
                        from
                              (
                                    select
                                          concat(first_id, ',', second_id) pair,
                                          follower_id
                                    from
                                          (
                                                select
                                                      distinct if(
                                                            Relations.user_id < r.user_id,
                                                            Relations.user_id,
                                                            r.user_id
                                                      ) first_id,
                                                      if(
                                                            Relations.user_id > r.user_id,
                                                            Relations.user_id,
                                                            r.user_id
                                                      ) second_id,
                                                      Relations.follower_id
                                                from
                                                      Relations
                                                      inner join Relations r on Relations.user_id != r.user_id
                                                where
                                                      Relations.follower_id = r.follower_id
                                          ) mid
                              ) mid2
                        group by
                              pair
                  ) mid3
      ) mid4
where
      r = 1;