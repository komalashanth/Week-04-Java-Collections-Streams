public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }

    public static void main(String[] args) {
        String[] usernames = {"user_123", "123user", "us", "User_Name15", "user!", "user_name_is_way_too_long"};

        for (String username : usernames) {
            System.out.println(username + " → " + (isValidUsername(username) ? "Valid" : "Invalid"));
        }
    }
}
