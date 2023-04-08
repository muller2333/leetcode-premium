select user1_id user_id, page_id, count(user1_id) friends_likes
from (select mid2.user1_id, mid2.page_id
      from (select mid.user1_id, page_id
            from (select user1_id, user2_id
                  from Friendship
                  union all
                  select user2_id user1_id, user1_id user2_id
                  from Friendship) mid
                     left join
                 Likes on Likes.user_id = mid.user2_id) mid2
               left join Likes on Likes.user_id = mid2.user1_id and Likes.page_id = mid2.page_id
      where Likes.page_id is null) mid3
group by user1_id, page_id;