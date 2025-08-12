package com.mining.crypto.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RolePermissions {
    public static final Map<String, List<String>> ROLE_PERMISSION_MAP = new HashMap<>();

    static {
        ROLE_PERMISSION_MAP.put("ADMIN", List.of("/mining_rig/getAll",
                                                 "/mining_rig/updateStatus",
                                                 "/mining_rig/addMiningRig",
                                                 "/user_benefit/getAll",
                                                 "/user/getAllPage",
                                                 "/user/addUser"));
        ROLE_PERMISSION_MAP.put("USER", List.of(""));
        ROLE_PERMISSION_MAP.put("GUEST", List.of("/user/login"));
    }
}