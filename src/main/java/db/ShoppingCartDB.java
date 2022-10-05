package db;

import bo.Item;
import bo.ShoppingCart;
import bo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ShoppingCartDB extends bo.ShoppingCart {
    /*
    public static ShoppingCart getShoppingCart(int id) {
        ShoppingCart cart = null;
        try {
            Connection con = DBManger.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from SHOPPING_CART WHERE idShopping_cart = "+id+";");

            while (rs.next()) {
                int cartId = rs.getInt("idShopping_cart");
                String username = rs.getString("user");
                List<Item> items = getItems(cartId);
                // getUser
                cart = new ShoppingCartDB(cartId, username, items);
            }
            con.close();
        } catch (SQLException e) {e.printStackTrace();}

        return cart;
    }

    private static List<Item> getItems(int cartId) {
        List<Item> items = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idItem FROM ITEM-SHOPPING_CART WHERE idShopping_cart =" +cartId+ ";");

            while (rs.next()) {
                int itemId = rs.getInt("idItem");
                items.add(getItem(itemId));
            }
        } catch (SQLException e) {e.printStackTrace();}

        return items;
    }

     */

    private ShoppingCartDB(int id, String user, List<Item> items) {
        super(id, user, items);
    }
}
