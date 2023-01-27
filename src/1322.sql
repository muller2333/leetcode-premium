select mid3.ad_id, if(cnt2 + cnt = 0, 0, round(100 * cnt / (cnt + cnt2), 2)) ctr
from (select mid.ad_id, ifnull(cnt, 0) cnt
      from (select distinct ad_id from Ads) mid
               left join (select ad_id, count(user_id) cnt from Ads where action = 'Clicked' group by ad_id) mid2
                         on mid2.ad_id = mid.ad_id) mid3
         inner join
     (select mid.ad_id, ifnull(cnt2, 0) cnt2
      from (select distinct ad_id from Ads) mid
               left join (select ad_id, count(user_id) cnt2 from Ads where action = 'Viewed' group by ad_id) mid2
                         on mid2.ad_id = mid.ad_id) mid4
     on mid3.ad_id = mid4.ad_id
order by ctr desc, mid3.ad_id;