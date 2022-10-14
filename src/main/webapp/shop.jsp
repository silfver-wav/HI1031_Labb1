<%@ page import="ui.ItemInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: linus
  Date: 2022-10-07
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Cart</title>
      <link rel="stylesheet" href="style.css">
      <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>

    <body>
        <header>
          <!--Nav-->
          <div class="nav container">
            <a href="index.jsp" class="logo">Homepage</a>

              <!--Cart Redirect-->
              <a href = "${pageContext.request.contextPath}/cart-servlet?action=LIST">
                  <i type="button" class='bx bx-shopping-bag' id="cart-icon"></i>
              </a>
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

    <!--Shop -->
        <section class="shop container">
          <h2 class="section-title"> Shop Products</h2>
          <!--Content-->
            <%
                session = request.getSession();
                List<ItemInfo> items = (List<ItemInfo>) session.getAttribute("shoplist");
                if (items!=null) {
                Iterator<ItemInfo> it = items.iterator();
                while (it.hasNext()) {
                    ItemInfo item = it.next();
            %>
          <div class="product-box">
            <h2 class="product-title"><%= item.getName()%></h2>
            <p class="description"><%= item.getDescription()%></p>
            <p class="in-stock">In Stock:<% if (item.inStock()) { %> Yes <% } else %> No </p>
            <span class="price">$25</span>
              <% if (item.inStock()) { %>
              <!--Add to cart button-->
              <form action="${pageContext.request.contextPath}/cart-servlet?action=PUT" method="post">
                  <button type="submit" name="itemId" class="bx bx-shopping-bag add-cart" value=<%=item.getId()%>></button>
              </form>
              <% } %>
          </div>
          <% }
          }%>

        </section>
    </body>
</html>
