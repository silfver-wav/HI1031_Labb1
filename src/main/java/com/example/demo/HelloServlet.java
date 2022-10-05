package com.example.demo;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;

import bo.ItemHandler;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ui.ItemInfo;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>" + "<h1>Parameters</h1><ul>");
        Collection<ItemInfo> items = ItemHandler.getItemWithGroup("frukt");
        Iterator<ItemInfo> it = items.iterator();
        for (; it.hasNext();) {
            ItemInfo item = it.next();
            out.println("<li>"+ item.getName() +" = "+ item.getDescription() );
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}