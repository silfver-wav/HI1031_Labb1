package db;

import bo.Item;
import bo.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A representation of an order database
 */
public class OrderDB extends Order {

    /**
     * Search for an order by username
     * @param username the username
     * @return the order
     */
    public static OrderDB getOrderByUsername(String username) {
        OrderDB cart = null;
        try (Connection con = DBManager.getConnection()) {
            String sql = "SELECT * FROM order_T WHERE user='" + username + "'";
            PreparedStatement prepState = con.prepareStatement(sql);
            ResultSet rs = prepState.executeQuery(sql);

            while(rs.next()) {
                int id = rs.getInt("idOrder");
                String user = rs.getString("user");

                List<Integer> items = getItemIds(id);
                cart = new OrderDB(id, user, items);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cart;
    }

    /**
     * Search for items by id
     * @param orderId the id of the order
     * @return a list of items by id
     */
    private static List<Integer> getItemIds(int orderId) {
        List<Integer> itemIds = new ArrayList<>();
        try (Connection con = DBManager.getConnection()) {
            String sql = "SELECT idItem FROM item_order_T WHERE idOrder='" +orderId+ "'";
            PreparedStatement prepState = con.prepareStatement(sql);
            ResultSet rs = prepState.executeQuery(sql);

            while(rs.next()) {
                int id = rs.getInt("idItem");
                itemIds.add(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemIds;
    }

    /**
     * Add an order to the database within a transaction - using username and list of item ids
     * @param username the username
     * @param itemIds item ids
     * @return true if the order was added | false if the order was unsuccessful
     */
    public static boolean addOrderToDatabase(String username, List<Integer> itemIds) {
        boolean rs = false;
        try (Connection con = DBManager.getConnection()) {
            con.setAutoCommit(false);
            try {
                int orderId = addOrder(username);

                for(int i = 0; i < itemIds.size(); i++) {
                    addItemToOrder(orderId, itemIds.get(i));
                    StorageDB.incramentById(itemIds.get(i));
                }
                con.commit();
                rs = true;
            } catch (SQLException e) {
                e.printStackTrace();
                con.rollback();
                con.setAutoCommit(true);
            } finally {
                con.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private static int addOrder(String username) {

        int orderId = 0;
        try (Connection con = DBManager.getConnection()) {

            String sql = "INSERT INTO order_T (user) VALUES (?)";
            PreparedStatement prepState = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepState.setString(1, username);

            int rowsInserted = prepState.executeUpdate();
            if (rowsInserted > 0 ) {
                System.out.println("Insert successful");
            }
            ResultSet rs = prepState.getGeneratedKeys();
            while(rs.next()) {
                orderId = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderId;
    }

    private static void addItemToOrder(int orderId, int itemId) {

        try(Connection con = DBManager.getConnection()) {
            String sql = "INSERT INTO item_order_T (idOrder, idItem) VALUES (?, ?)";
            PreparedStatement prepState = con.prepareStatement(sql);
            prepState.setInt(1, orderId);
            prepState.setInt(2, itemId);

            int rowsInserted = prepState.executeUpdate();
            if (rowsInserted > 0 ) {
                System.out.println("Item added succesfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    protected OrderDB( int id, String username, List <Integer> items){
        super(id, username, items);
    }
}
