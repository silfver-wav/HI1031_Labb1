package bo;

import ui.ItemInfo;
import ui.UserInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class UserHandler {
    public static UserInfo getUser(String username) {
        User user = User.searchUser(username);
        return new UserInfo(user.getUsername(),user.getName(),user.getEmail(),user.getPassword(),3);
    }

    public static boolean addUser(String username, String name, String email, String pwd, int access) {
        return User.addUser(new User(username, name, email, pwd, access));
    }

    public static List<UserInfo> getUsers() {
        Collection c = User.getUsers();
        ArrayList<UserInfo> users = new ArrayList<>();
        for(Iterator it = c.iterator(); it.hasNext();) {
            User user = (User) it.next();
            users.add(new UserInfo(user.getUsername(), user.getName(), user.getEmail(),null, user.getAccess()));
        }
        return users;
    }

    public static boolean editUserAccess(String username, int access) {
        return User.editUserAccess(username, access);
    }
}
