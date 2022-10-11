package ui;

import bo.UserHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * A representation of a login servlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login-servlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserInfo user = UserHandler.getUser(username);
        System.out.println("access: "+user.getAccess());
        if (user!=null) {
            if(password.equals(user.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                request.getRequestDispatcher("index.jsp").include(request, response);
            }
        } else {
            out.print("Sorry, username or password error!");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }

        out.close();
    }

}