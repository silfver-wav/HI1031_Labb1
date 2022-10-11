package ui;

import bo.Item;
import bo.ItemHandler;
import bo.UserHandler;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user-servlet")
public class UserServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String action = request.getParameter("action");

        switch(action) {

            case "LIST":
                getUsers(request, response);
                break;
            default:
                break;

        }
    }

    private void getUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<UserInfo> users = UserHandler.getUsers();
        HttpSession session = request.getSession();
        session.setAttribute("userlist",users);

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");

        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String action = request.getParameter("action");

        switch(action) {

            case "INSERT":
                addUser(request, response);
                break;
            case "PUT":
                editUser(request, response);
                break;
            default:
                break;

        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String access = request.getParameter("access");

        boolean rs = false;
        if (access.equals("customer")) rs = UserHandler.editUserAccess(username, 1);
        else if (access.equals("employee")) rs = UserHandler.editUserAccess(username, 2);
        else rs = UserHandler.editUserAccess(username, 3);

        PrintWriter out = response.getWriter();
        if (rs) out.println("Account access changed");
        else out.println("Unable to change account access");

        request.getRequestDispatcher("adminPage.jsp").include(request, response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");

        // Insert User to the database
        boolean rs = UserHandler.addUser(username, name, email, pwd, 1);
        if (rs)
            request.getRequestDispatcher("login.jsp").include(request, response);
        else {
            PrintWriter out = response.getWriter();
            out.println("Unable to register account");
        }
    }


}
