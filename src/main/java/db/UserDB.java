package db;

import java.sql.*;
import java.util.Collection;
import java.util.Vector;

/**
 * A representation of a user database
 */
public class UserDB extends bo.User {

    /**
     * Search for users
     * @return a collection of users
     */
    public static Collection getUsers() {
        Vector v = new Vector();
        try (Connection con = DBManager.getConnection()){
            Statement st = con.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery("SELECT * from user"); // WHERE PERMISSION = cutsomer or det andra


            while (rs.next()) {
                String username = rs.getString("username");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int access = rs.getInt("access");
                v.addElement(new UserDB(username, name, email, null, access));
            }
        } catch (SQLException e) {
            e.printStackTrace();}

        return v;
    }

    /**
     * Search for user by username
     * @param username the username
     * @return the user
     */
    public static UserDB searchUser(String username) {

        UserDB user = null;

        try (Connection conn = DBManager.getConnection()) {
            String sql = "SELECT * from user WHERE username='" + username + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                String userName = rs.getString("username");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int access = rs.getInt("access");
                user = new UserDB(userName, name, email, password, access);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    /**
     * Add user to the database using username, name, email, password and access-level
     * @param username the username
     * @param name the name
     * @param email the email
     * @param password the password
     * @param access the access-level of the user
     * @return true if user was added | false if the user was not added
     */
    public static boolean addUser(String username, String name, String email, String password, int access) {
        try (Connection conn = DBManager.getConnection()){

            String sql = "INSERT INTO User (username, name, email, password, access) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setInt(5, access);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0 ) {
                System.out.println("A new user was inserted. Success.");
                return true;
            }
            else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Edit the access level of a user using username and the new access level
     * @param username the username
     * @param access the access level
     * @return true if user was updated successfully | false if the user was not updated
     */
    public static boolean editUserAccess(String username, int access) {
        try(Connection conn = DBManager.getConnection()) {

            String sql = "UPDATE User SET access=? WHERE username=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, access);
            statement.setString(2, username);

            int rowsUpdated = statement.executeUpdate();
            if(rowsUpdated > 0) {
                System.out.println("updated");
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * Update a user in the database using username, name, email and password
     * @param username the username
     * @param name the name
     * @param email the email
     * @param password the password
     */
    public static void updateUser(String username, String name, String email, String password) {

        try(Connection conn = DBManager.getConnection()) {

            String sql = "UPDATE User SET name=?, email=?, password=? WHERE username=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, username);

            int rowsUpdated = statement.executeUpdate();
            if(rowsUpdated > 0) {
                System.out.println("updated");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Delete a user using username
     * @param username the username
     */
    public static void deleteUser(String username) {

        try(Connection conn = DBManager.getConnection()) {

            String sql = "DELETE FROM User WHERE username=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            int rowsDeleted = statement.executeUpdate();
            if(rowsDeleted > 0 ) {
                System.out.println("user deleted");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected UserDB(String username, String name, String email, String password, int access) {
        super(username, name, email, password, access);
    }
}