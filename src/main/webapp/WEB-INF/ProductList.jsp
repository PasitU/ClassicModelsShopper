<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pluem
  Date: 12/16/2023
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product List</h1>
<a href="index.jsp">To Home</a> > Product Menu
<hr>
<c:if test="${productList != null}">
    <c:forEach items="${productList}" var="product">
        <form method="get" action="AddProduct">
            <input type="hidden" value="${currentSize}" name="size">
            <input type="hidden" value="${currentPage}" name="page">
            <div>
                ${product.productName}
                ${product.MSRP}
                <button value="${product.productCode}" name="productCode">Add to Cart ${sessionScope.cart != null && sessionScope.cart.getItem(product.productCode) != null ? sessionScope.cart.getItem(product.productCode).quantity : ''}</button>
        </div>
        </form>
    </c:forEach>
</c:if>
<form method="get" action="ProductList">
    <input type="hidden" value="${currentSize}" name="size">
    <hr>
    <c:if test="${totalPage > 1}">
            <button name="page" value=${currentPage <= 1 ? 1 : currentPage - 1}>&lt</button>
            <c:forEach varStatus="vs" begin="${1}" end="${totalPage}">
                <c:choose>
                    <c:when test="${vs.count == currentPage}">
                        <button disabled>${vs.index}</button>
                    </c:when>
                    <c:otherwise>
                        <button value="${vs.index}" name="page">${vs.index}</button>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <button name="page" value=${currentPage >= totalPage ? totalPage : currentPage + 1}>&gt</button>
    </c:if>
</form>

<form method="get" action="ProductList">Page Size:&nbsp
    <select name="size">
        <option value="${5}" ${currentSize == 5 ? "selected" : ""}>5</option>
        <option value="${10}" ${currentSize == 10 ? "selected" : ""}>10</option>
        <option value="${15}" ${currentSize == 15 ? "selected" : ""}>15</option>
        <option value="${20}" ${currentSize == 20 ? "selected" : ""}>20</option>
        <option value="${25}" ${currentSize == 25 ? "selected" : ""}>25</option>
        <option value="${30}" ${currentSize == 30 ? "selected" : ""}>30</option>
    </select>
    <button type="submit">Submit</button>
</form>
<hr>
<a href="ViewCart">See your Cart</a>
</body>
</html>
