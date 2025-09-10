select
     Posts.post_id,
     ifnull(topic, 'Ambiguous!') topic
from
     Posts
     left join (
          select
               post_id,
               group_concat(
                    topic_id
                    order by
                         topic_id
               ) topic
          from
               (
                    select
                         distinct topic_id,
                         post_id
                    from
                         (
                              select
                                   topic_id,
                                   lower(concat(' ', word, ' ')) word,
                                   post_id,
                                   lower(concat(' ', content, ' ')) content
                              from
                                   Keywords,
                                   Posts
                         ) mid
                    where
                         position(word in content) >= 1
                    order by
                         post_id,
                         topic_id
               ) mid2
          group by
               post_id
     ) mid3 on Posts.post_id = mid3.post_id;