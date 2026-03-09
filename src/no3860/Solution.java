package no3860;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniqueEmailGroups(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int idx = email.indexOf("@");
            String domain = email.substring(idx).toLowerCase();
            String local = email.substring(0, idx);
            idx = local.indexOf("+");
            if (idx >= 0) {
                local = local.substring(0, idx);
            }
            local = local.toLowerCase().replace(".", "");
            set.add(local + domain);
        }
        return set.size();
    }
}
