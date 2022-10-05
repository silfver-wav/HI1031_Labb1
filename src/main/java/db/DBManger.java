package db;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManger {

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:mysql://localhost:3306/web_shop?UseClientEnc=UTF8");
        ds.setUsername("root");
        ds.setPassword("pass123");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    private static DBManger instance = null;
    private Connection con = null;

    private static DBManger getInstance() {
        if (instance == null)
            instance = new DBManger();
        return instance;
    }

    private DBManger() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = ds.getConnection();
            System.out.println("Connected!");
        } catch (Exception e) {e.printStackTrace();}
        /*
        String user = "root"; // user name
        String pwd = "pass123"; // password
        String database = "web_shop"; // the name of the specific database
        String server = "jdbc:mysql://localhost:3306/" + database + "?UseClientEnc=UTF8";
        try {
            // Class.forName("com.mysql.jdbc.Driver").newInstance();
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            // con = DriverManager.getConnection("jdbc:mysql://localhost");
            con = DriverManager.getConnection(server, user, pwd);
            System.out.println("Connected!");
        } catch (Exception e) {e.printStackTrace();}
         */
    }


    public static Connection getConnection() {
        return getInstance().con;
    }

}
