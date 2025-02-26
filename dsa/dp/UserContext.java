package dsa.dp;

public class UserContext {
    // ThreadLocal variable to store user details per thread
    private static final ThreadLocal<String> userThreadLocal = new ThreadLocal<>();

    // Set user for current thread
    public static void setUser(String user) {
        userThreadLocal.set(user);
    }

    // Get user from current thread
    public static String getUser() {
        return userThreadLocal.get();
    }

    // Clear user from current thread
    public static void clear() {
        userThreadLocal.remove();
    }
}
