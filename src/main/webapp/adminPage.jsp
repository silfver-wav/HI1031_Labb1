<%@ page import="ui.UserInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: linus
  Date: 2022-10-11
  Time: 13:53
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

  <!--Shop -->
  <section class="shop container">
    <h2 class="section-title"> Shop Products</h2>
    <!--Content-->
    <%
      session = request.getSession();
      List<UserInfo> users = (List<UserInfo>) session.getAttribute("userlist");
      if (users!=null) {
        Iterator<UserInfo> it = users.iterator();
        while (it.hasNext()) {
          UserInfo user = it.next();
    %>
    <div class="product-box">
      <h2 class="product-title"><%= user.getUsername()%></h2>
      <p class="description"><%= user.getName()%></p>
      <!--Set Access-->
      <form action="${pageContext.request.contextPath}/user-servlet?action=PUT" method="post">
        Customer: <input type="radio" name="access" value="customer" type="checkbox" checked>
        Warehouse employee: <input type="radio" name="access" value="employee" type="checkbox" checked>
        Admin: <input type="radio" name="access" value="admin" type="checkbox" checked>
        <button type="submit" name="username" value=<%=user.getUsername()%>>Submit</button>
      </form>
      <% } %>
    </div>
    <% } %>

  </section>
  </body>
</html>
