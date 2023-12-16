<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pluem
  Date: 12/15/2023
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .office {
            height: 8em;
            margin: 10px;
            padding: 20px;
            font-size: 15px;
            border: 1px solid #ccc !important;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<h1>Office List</h1>
<a href="index.jsp">To Home</a> > Office Menu
<hr>
<div style="display: flex; flex-wrap: wrap">
    <c:forEach var="office" items="${officeList}">
        <div class="office">
                <a href="OfficeMenu?officeCode=${office.officeCode}" >
                ${office.officeCode}.) ${office.city}, ${office.country}<br>
                ${office.phone}</a>
            <div>
                <form method="get" action="UpdateOffice">
                    <button name="officeCode" value="${office.officeCode}">Update Office</button>
                </form>
                <form method="post" action="DeleteOffice">
                    <button name="deleteCode" value="${office.officeCode}">Delete Office</button>
                </form>
            </div>
        </div>
    </c:forEach>
    <a href="CreateOffice">
        <div class="office"><p style="margin: auto">++ Create a New Office++</p></div>
    </a>
</div>
<hr>
<c:if test="${empList != null}">
    <c:forEach items="${empList}" var="emp">
        <div>
            ${emp}
        </div>
    </c:forEach>
</c:if>
<c:if test="${error != null}">
    ${error}
</c:if>
</body>
</html>
