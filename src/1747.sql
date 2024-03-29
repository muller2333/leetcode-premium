select
    distinct l.account_id
from
    LogInfo
    inner join LogInfo l on LogInfo.account_id = l.account_id
    and LogInfo.ip_address != l.ip_address
    and LogInfo.login <= l.logout
where
    LogInfo.logout >= l.login;