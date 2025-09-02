package com.mining.crypto.util;

public class UserContext {
    private static final ThreadLocal<String> USER_HOLDER = new ThreadLocal<>();

    public static void setUsername(String username) {
        USER_HOLDER.set(username);
    }

    public static String getUsername() {
        return USER_HOLDER.get();
    }

    public static void clear() {
        USER_HOLDER.remove();
    }
}