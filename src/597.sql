select
    ifnull(round(cnt / cnt2, 2), 0) accept_rate
from
    (
        select
            count(distinct requester_id, accepter_id) cnt
        from
            RequestAccepted
    ) mid
    inner join (
        select
            count(distinct sender_id, send_to_id) cnt2
        from
            FriendRequest
    ) mid2;