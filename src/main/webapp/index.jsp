<%@ page import="ui.ShoppingCartServlet" %>
<%@ page import="bo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="ui.ItemInfo" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="bo.Order" %>
<%@ page import="ui.UserInfo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Web Shop</title>
        <link rel="stylesheet" href="style.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>

    <body>
        <header>
            <!--Nav-->
            <div class="nav container">
                <a href="#" class="logo">E-Shop</a>

                <!--<i type="button" class='bx bx-shopping-bag' id="cart-icon" onclick="document.getElementById('cartDiv').style.display='block'"></i>-->

                <!--Shop Redirect-->
                <a href = "${pageContext.request.contextPath}/item-servlet?action=LIST">
                    <i type="button" class='bx bx-store' id="store-icon"></i>
                </a>

                <!--Cart Redirect-->
                <a href = "${pageContext.request.contextPath}/cart-servlet?action=LIST">
                    <i type="button" class='bx bx-shopping-bag' id="cart-icon"></i>
                </a>

                <a href="login.jsp">Login</a>

            </div>
        </header>

        <style>
            body {
                background-image: url(https://images.unsplash.com/photo-1446034295857-c39f8844fad4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80);
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
            }
        </style>



        <div class="middle">
               <h1>Welcome</h1>
        </div>


            <section class="shop container">
                <% session = request.getSession();
                    UserInfo user = (UserInfo) session.getAttribute("user");
                    if (user != null) {
                        System.out.println(user.getUsername());
                        if (user.getAccess() == 3) {
                %>
                <a href = "${pageContext.request.contextPath}/user-servlet?action=LIST" >
                    <i type="button" >Admin Page </i>
                </a>
                <% } }%>
            </section>

    </body>
</html>