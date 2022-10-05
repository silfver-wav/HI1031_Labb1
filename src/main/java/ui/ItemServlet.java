package ui;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "itemServlet", value = "/item-servlet")
public class ItemServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
