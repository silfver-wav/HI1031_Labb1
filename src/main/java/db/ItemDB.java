package db;

import bo.Item;

import java.sql.*;
import java.util.Collection;
import java.util.Vector;


/**
 * A representation of an item database
 */
public class ItemDB extends bo.Item{


    /**
     * Search for an item in a specific item group
     * @param item_group the item group to search for
     * @return a collection of items
     */
    public static Collection searchItem(String item_group) {
        Vector v = new Vector();
        try (Connection con = DBManager.getConnection()){
            Statement st = con.createStatement();
            ResultSet rs = null;
            if (item_group.equals("none"))
                rs = st.executeQuery("SELECT * from item"); // lägg till spefik group
            else
                rs = st.executeQuery("SELECT * from item");

            while (rs.next()) {
                int i = rs.getInt("idItem");
                String name = rs.getString("name");
                String desc = rs.getString("desc");
                int quantity = rs.getInt("quantity");

                v.addElement(new ItemDB(i, name, desc, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();}

        return v;
    }


    /**
     * Search for an item by id
     * @param id the id of the item
     * @return the item from database
     */
    public static ItemDB getItem(int id) {
        ItemDB item = null;
        try (Connection con = DBManager.getConnection()) {
            String sql = "SELECT * FROM ITEM WHERE idItem ='"+id+"'";
            PreparedStatement prepState = con.prepareStatement(sql);
            ResultSet rs = prepState.executeQuery(sql);

            while (rs.next()) {
                int i = rs.getInt("idItem");
                String name = rs.getString("name");
                String desc = rs.getString("desc");
                int quantity = rs.getInt("quantity");

                item = new ItemDB(i, name, desc,quantity);
            }
        } catch (SQLException e) {e.printStackTrace();}

        return item;
    }


    private ItemDB(int id, String name, String desc, int quantity) {
        super(id, name, desc, null,quantity);
    }
}
