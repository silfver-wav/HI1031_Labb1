package ui;

import bo.ItemHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "itemServlet", value = "/item-servlet")
public class ItemServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getParameter("action");


        switch(action) {
            case "LIST":
                listItems(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        // processRequest(request, response);
    }

    protected static void listItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ItemInfo> items = ItemHandler.getItems("none");

        HttpSession session = request.getSession();
        session.setAttribute("shoplist", items);
        //request.setAttribute("list", items);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop.jsp");

        dispatcher.forward(request, response);
    }
}
