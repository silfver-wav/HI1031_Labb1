package bo;

import db.UserDB;

import java.util.Collection;

/**
 * A representation of a user
 */
public class User {
    private String username;
    private String name;
    private String email;
    private String password;
    private int access;

    static public boolean editUserAccess(String username, int access) { return UserDB.editUserAccess(username, access);}
    static public Collection getUsers() { return UserDB.getUsers();}
    static public User searchUser(String username) { return UserDB.searchUser(username); }
    static public boolean addUser(User user) { return UserDB.addUser(user.getUsername(), user.getName(), user.getEmail(), user.getPassword(), user.access); }

    protected User(String username, String name, String email, String password, int access) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.access = access;
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }
}
