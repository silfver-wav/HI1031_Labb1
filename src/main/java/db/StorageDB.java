package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StorageDB {
    public static boolean getStorageByItemId(int id) {
        boolean inStorage = false;
        try (Connection con = DBManager.getConnection()) {
            String sql = "SELECT quantity FROM Storage WHERE idItem ='"+id+"'";
            PreparedStatement prepState = con.prepareStatement(sql);
            ResultSet rs = prepState.executeQuery(sql);

            while (rs.next()) {
                int quantity = rs.getInt("quantity");

                if (quantity > 0)
                    inStorage = true;
            }
        } catch (SQLException e) {e.printStackTrace();}

        return inStorage;
    }

    public static void incramentById(int id) {
        try (Connection con = DBManager.getConnection()) {
            String sql = "UPDATE Storage SET quantity = quantity - 1 WHERE idItem ='"+id+"'";
            PreparedStatement statement = con.prepareStatement(sql);
            int rowsUpdated = statement.executeUpdate();
            if(rowsUpdated > 0) {
                System.out.println("updated");
            }
        } catch (SQLException e) {e.printStackTrace();}
    }
}