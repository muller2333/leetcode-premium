select
    bit_and(permissions) common_perms,
    bit_or(permissions) any_perms
from
    user_permissions