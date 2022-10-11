<%--
  Created by IntelliJ IDEA.
  User: linus
  Date: 2022-10-09
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login.css" />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  </head>

<body>
<form class="box" action="${pageContext.request.contextPath}/login-servlet" method="post">
  <h1>Login</h1>
  <input type="text" name="username" placeholder="Username">
  <input type="password" name="password" placeholder="Password">
  <input type="submit" name="" value="Login">
</form>

  <!--Register account-->
  <div style="display:grid; justify-content:center" class="register">
    <a href="register.jsp">Create new account</a>
  </div>

</body>
</html>
