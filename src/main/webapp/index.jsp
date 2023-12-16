<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<H1>Classic Models Manager</H1>
<c:choose>
    <c:when test="${sessionScope.user != null}">
        <h3>Welcome, ${sessionScope.user}</h3>
    </c:when>
    <c:otherwise>
        <h3>Welcome, Guest</h3>
    </c:otherwise>
</c:choose>
<br/>
<a href="OfficeMenu">Office Menu</a><br>
<a href="ProductList">Our Products</a>
<form action="Login" method="post">
    <c:choose>
        <c:when test="${sessionScope.user != null}">
                <input type="submit" value="Logout">
        </c:when>
        <c:otherwise>
            <a href="login.jsp">Login</a>
        </c:otherwise>
    </c:choose>
</form>
</body>
</html>