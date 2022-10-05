package db;

import bo.Item;

import java.sql.*;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class ItemDB extends bo.Item{
 public static Collection searchItem(String item_group) {
     System.out.println("here");
     Vector v = new Vector();
     try {
         Connection con = DBManger.getConnection();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * from ITEM");

         while (rs.next()) {
             int i = rs.getInt("idItem");
             String name = rs.getString("name");
             String desc = rs.getString("desc");
             System.out.println("name: "+name+" desc: "+desc);
             v.addElement(new ItemDB(i, name, desc));
         }
         con.close();
     } catch (SQLException e) {e.printStackTrace();}

     return v;
    }
/*
    public static Item getItem(int id) {
        Item item = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ITEM WHERE idItem ="+id+";");

            while (rs.next()) {
                int i = rs.getInt("idItem");
                String name = rs.getString("name");
                String desc = rs.getString("desc");
                item = new Item(i, name, desc);
            }
        } catch (SQLException e) {e.printStackTrace();}

        return item;
    }
 */

    private ItemDB(int id, String name, String desc) {
     super(id, name, desc);
    }

}
