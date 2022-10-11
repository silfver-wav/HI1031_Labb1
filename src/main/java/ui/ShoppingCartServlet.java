package ui;

import bo.ItemHandler;
import bo.OrderHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "CartServlet", urlPatterns = "/cart-servlet")
public class ShoppingCartServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getParameter("action");

        String[] arrOfStr = action.split("_");


        switch(arrOfStr[0]) {

            case "LIST":
                getShoppingCart(request, response);
                break;
            case "REMOVE":
                removeItem(request, response);
                break;
            case "PUT":
                doPost(request,response);
            default:
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");



        switch(action) {

            case "PUT":
                addItemToCart(request,response);
                break;
            case "INSERT":
                createOrder(request, response);
                break;
            default:
                break;

        }
    }

    private void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCartInfo cart = (ShoppingCartInfo) session.getAttribute("cart");
        if (cart!=null) {
            Iterator<ItemInfo> it = cart.getItems().iterator();
            List<Integer> itemIds = new ArrayList<>();
            while (it.hasNext()) {
                itemIds.add(it.next().getId());
            }
            boolean rs = OrderHandler.insertOrder(cart.getUser().getUsername(), itemIds);
            if (rs) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Unable to make order");
            RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
            dispatcher.forward(request, response);
        }


    }
    private void addItemToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCartInfo cart = (ShoppingCartInfo) session.getAttribute("cart");

        if (cart==null) {
            UserInfo user = (UserInfo) session.getAttribute("user");
            cart = new ShoppingCartInfo(user, new ArrayList<>());
        }
        String itemId = request.getParameter("itemId");
        cart.addItem(ItemHandler.getItem(Integer.parseInt(itemId)));


        session.setAttribute("cart",cart);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop.jsp");
        dispatcher.forward(request, response);
    }

    private void getShoppingCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCartInfo cart = (ShoppingCartInfo) session.getAttribute("cart");
        if (cart != null)
            request.setAttribute("list", cart.getItems());
        else
            request.setAttribute("list", new ArrayList<>());
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
        dispatcher.forward(request, response);
    }

    private void removeItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCartInfo cart = (ShoppingCartInfo) session.getAttribute("cart");

        String idstr = (String) request.getAttribute("itemId");
        int id = Integer.parseInt(idstr);

        List<ItemInfo> items = cart.getItems();
        Iterator<ItemInfo> it = items.iterator();
        while (it.hasNext()) {
            ItemInfo item = it.next();
            if (item.getId() == id) {
                cart.getItems().remove(item);
                break;
            }
        }

        session.setAttribute("cart",cart);

        RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
        dispatcher.forward(request, response);
    }

}
