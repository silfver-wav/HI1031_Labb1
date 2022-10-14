<%@ page import="ui.ItemInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="ui.ShoppingCartInfo" %><%--
  Created by IntelliJ IDEA.
  User: linus
  Date: 2022-10-06
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/cart.css" />
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>

    <body>
        <!--Header-->
        <header>
          <!--Nav-->
          <div class="nav container">
            <a href="index.jsp" class="logo">Homepage</a>
          </div>
        </header>

        <!--Cart -->
        <section class="cart">
          <h2 class="cart-title">Your Cart</h2>

          <!--Content-->
          <div class="cart-content">
              <%
                  session = request.getSession();
                  ShoppingCartInfo cart = (ShoppingCartInfo) session.getAttribute("cart");
                  if (cart != null) {
                    List<ItemInfo> items = cart.getItems();
                  if (items==null || items.isEmpty()) {
              %>
                    <div class="cart-product-title">The Cart Is Empty</div>
                  <%} else {
                  Iterator<ItemInfo> it = items.iterator();
                  while (it.hasNext()) {
                      ItemInfo item = it.next();
              %>
            <div class="cart-box">
              <div class="detail-box">
                <div class="cart-product-title"><%=item.getName()%></div>
                <div class="cart-price">$25</div>
                <input type="number" value="1" class="cart-quantity">
              </div>
              <!--Remove Cart-->
                <form action="${pageContext.request.contextPath}/cart-servlet?action=REMOVE" method="post">
                    <button type="submit" name="id" class="bx bxs-trash-alt cart-remove" value=<%=item.getId()%>>
                        <% session.setAttribute("Item",item); %>
                    </button>
                </form>
            </div>
            <% }
                  }
            }
            %>
          </div>
          <!--Total-->
          <div class="total">
            <div class="total-title">Total</div>
            <div class="total-price">$0</div>
          </div>
          <!--Buy Button-->
          <form action="${pageContext.request.contextPath}/cart-servlet?action=INSERT" method="post">
            <button type="submit" class="btn-buy">Order</button>
          </form>

        </section>

    </body>
</html>