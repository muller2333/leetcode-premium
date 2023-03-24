select user_id, gender
from (
         (select user_id, gender, @rownum := @rownum + 3 rownum
          from (select user_id, gender from Genders where gender = 'female' order by user_id) mid,
               (select @rownum := -2) rownum)
         union
         (select user_id, gender, @rownum2 := @rownum2 + 3 rownum
          from (select user_id, gender from Genders where gender = 'other' order by user_id) mid,
               (select @rownum2 := -1) rownum)
         union
         (select user_id, gender, @rownum3 := @rownum3 + 3 rownum
          from (select user_id, gender from Genders where gender = 'male' order by user_id) mid,
               (select @rownum3 := 0) rownum)
     ) mid4
order by rownum