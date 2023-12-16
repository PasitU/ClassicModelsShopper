<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pluem
  Date: 12/16/2023
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Cart</h1>
<a href="index.jsp">To Home</a> > <a href="ProductList">Product Menu</a> > Cart
<hr>
<c:if test="${sessionScope.cart != null || ! empty sessionScope.cart.cart}">
    <table>
        <c:forEach items="${sessionScope.cart.cart}" var="product">
                <tr>
                    <td>
                        ${product.key}
                    </td>
                    <td>
                        ${product.value.quantity}
                    </td>
                    <td>
                        ${product.value.getPrice()}
                    </td>
                    <td>
                        <form action="DeleteFromCart" method="get">
                            <button name="productCode" value="${product.key}">Remove product</button>
                        </form>
                    </td>
                </tr>
        </c:forEach>
        <tr>
            <td>Total Price
            </td>
            <td>${sessionScope.cart.getTotalPrice()}</td>
        </tr>
    </table>
    <a href="ClearCart">Clear Cart</a>
</c:if>
</body>
</html>
