select substring(pair, 1, position(',' in pair) - 1) / 1 user1_id,
       substring(pair, position(',' in pair) + 1) / 1    user2_id,
       cnt                                               common_friend
from (
         select count(pair) cnt, pair
         from (select concat(first_id, ',', second_id) pair, user2_id
               from (select distinct if(mid.user1_id < mid2.user1_id, mid.user1_id, mid2.user1_id) first_id,
                                     if(mid.user1_id > mid2.user1_id, mid.user1_id, mid2.user1_id) second_id,
                                     mid.user2_id
                     from (select user1_id, user2_id
                           from Friendship
                           union
                           select user2_id user1_id, user1_id user2_id
                           from Friendship) mid
                              inner join (select user1_id, user2_id
                                          from Friendship
                                          union
                                          select user2_id user1_id, user1_id user2_id
                                          from Friendship) mid2 on mid.user1_id != mid2.user1_id
                     where mid.user2_id = mid2.user2_id) mid3) mid4
         group by pair
     ) mid5
where cnt >= 3
  and pair in (select concat(user1_id, ',', user2_id) from Friendship);