select Members.member_id,
       name,
       if(mid3.member_id is null, 'Bronze',
          case
              when conversion_rate >= 80 then 'Diamond'
              when conversion_rate >= 50 then 'Gold'
              else 'Silver'
              end) category
from (select mid2.member_id, 100 * ifnull(cnt, 0) / cnt2 conversion_rate
      from (select member_id, count(member_id) cnt
            from Visits
                     right join Purchases on Purchases.visit_id = Visits.visit_id
            group by member_id) mid
               right join
           (select member_id, count(member_id) cnt2
            from Visits
                     left join Purchases on Purchases.visit_id = Visits.visit_id
            group by member_id) mid2
           on mid2.member_id = mid.member_id) mid3
         right join Members on Members.member_id = mid3.member_id;