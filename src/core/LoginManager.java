package core;

import exception.LoginFailedException;

/**
 * Singleton Login Manager
 */
public class LoginManager {

    private static LoginManager instance;

    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";

    // private constructor
    private LoginManager() {
    }

    public static LoginManager getInstance() {
        if (instance == null) {
            instance = new LoginManager();
        }
        return instance;
    }

    public void login(String username, String password) {
        if (!USERNAME.equals(username) || !PASSWORD.equals(password)) {
            throw new LoginFailedException("Username or password is incorrect.");
        }
    }
}