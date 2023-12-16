<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pluem
  Date: 12/16/2023
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="Login">
    <input type="text" placeholder="username" name="user">
    <input type="text" placeholder="password" name="password">
    <input type="submit">
</form>
<c:if test="${error != null}">
    ${error}
</c:if>
</body>
</html>
