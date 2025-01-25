select
    first_name,
    type,
    duration_formatted
from
    Contacts
    right join (
        select
            contact_id,
            type,
            duration,
            concat(
                concat(if(hours >= 10, '', '0'), hours),
                ':',
                concat(if(minutes >= 10, '', '0'), minutes),
                ':',
                concat(if(seconds >= 10, '', '0'), seconds)
            ) duration_formatted
        from
            (
                select
                    contact_id,
                    type,
                    duration,
                    floor(duration / 3600) hours,
                    floor((duration % 3600) / 60) minutes,
                    duration % 60 seconds,
                    dense_rank() over(
                        partition by type
                        order by
                            duration desc
                    ) rk
                from
                    Calls
            ) mid
        where
            rk <= 3
    ) mid2 on mid2.contact_id = Contacts.id
order by
    type desc,
    duration desc,
    first_name desc