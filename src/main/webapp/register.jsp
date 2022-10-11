<%--
  Created by IntelliJ IDEA.
  User: linus
  Date: 2022-10-10
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create New Account Page</title>
    <link rel="stylesheet" href="login.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>

<body>
    <form class="box" action="${pageContext.request.contextPath}/user-servlet?action=INSERT" method="post">
        <h1>Insert Details</h1>
        <input type="text" name="email" placeholder="Email">
        <input type="text" name="name" placeholder="Name">
        <input type="text" name="username" placeholder="Username">
        <input type="password" name="password" placeholder="Password">
        <input type="submit" name="" value="Register">
    </form>
</body>

</html>
