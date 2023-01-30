select distinct title
from TVProgram
         right join (select title, content_id from Content where Kids_content = 'Y' and content_type = 'Movies') mid
                    on mid.content_id = TVProgram.content_id
where left(program_date, 7) = '2020-06';