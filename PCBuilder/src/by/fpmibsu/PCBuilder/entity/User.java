package by.fpmibsu.PCBuilder.entity;

public class User {
    private boolean admin;
    private String login;
    private String hashPassword;

    public User(boolean admin, String login, String hashPassword) {
        this.admin = admin;
        this.login = login;
        this.hashPassword = hashPassword;
    }
}
