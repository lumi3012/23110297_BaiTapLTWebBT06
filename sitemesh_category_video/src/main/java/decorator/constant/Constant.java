package decorator.constant;

public class Constant {
	public static final String ATTR_USER = "currentUser";

    // Cookie name for remember-me
    public static final String COOKIE_REMEMBER = "rememberUser";

    // Roles
    public static final int ROLE_ADMIN = 1;
    public static final int ROLE_MANAGER = 2;
    public static final int ROLE_USER = 3;

    // Messages (for errors)
    public static final String MSG_USERNAME_EXISTS = "Username already exists";
    public static final String MSG_EMAIL_EXISTS = "Email already exists";
    public static final String MSG_INVALID_LOGIN = "Invalid username or password";
    public static final String MSG_REQUIRED = "Please fill in all required fields";
}
