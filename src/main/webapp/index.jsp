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
                <a href="#" class="logo">Panda Shop</a>

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

        <section class="shop container">
        <% HttpSession session1 = request.getSession();
            UserInfo user = (UserInfo) session1.getAttribute("user");
            if (user != null) {
                if (user.getAccess() == 3) {
        %>
        <a href = "${pageContext.request.contextPath}/user-servlet?action=LIST" >
            <i type="button" >Admin Page </i>
        </a>
        <% } }%>
        </section>

    </body>
</html>