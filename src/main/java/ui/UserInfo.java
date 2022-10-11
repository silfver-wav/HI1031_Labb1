package ui;

public class UserInfo {
    private String username;
    private String name;
    private String email;
    private String password;
    private int access;

    public UserInfo(String username, String name, String email, String password, int access) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.access = access;
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

    public boolean isEmpty() {
        return username==null;
    }
}
