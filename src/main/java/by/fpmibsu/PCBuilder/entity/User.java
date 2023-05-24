package by.fpmibsu.PCBuilder.entity;

public class User {
    private int id;
    private boolean admin;
    private String login;
    private String hashPassword;

    private String email;

    private boolean fromGoogle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id, String login, String hashPassword, boolean admin, String email, boolean fromGoogle) {
        this.id = id;
        this.admin = admin;
        this.login = login;
        this.hashPassword = hashPassword;
        this.email = email;
    }


    public User(String login, String hashPassword, boolean admin, String email) {
        this.admin = admin;
        this.login = login;
        this.hashPassword = hashPassword;
        this.email = email;
    }

    public User() {
    }

    @Override
    public String toString() {
        return id + " " + login + " " + hashPassword + " " + admin + " " + fromGoogle;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFromGoogle() {
        return fromGoogle;
    }

    public void setFromGoogle(boolean fromGoogle) {
        this.fromGoogle = fromGoogle;
    }
}
