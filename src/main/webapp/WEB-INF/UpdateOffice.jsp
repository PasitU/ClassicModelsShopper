<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pluem
  Date: 12/15/2023
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error{
            color:red;
        }
        .message{
            color:green;
        }
        .ass{
            color: red;
        }
    </style>
</head>
<body>
<h1>Update Office::</h1>
<a href="index.jsp">To Home</a> > <a href="OfficeMenu">Office Menu</a> > Update Office ${officeToUp.officeCode}
<hr>
<c:if test="${officeToUp != null}">
    <form action="UpdateOffice" method="post">
        <input type="hidden" name="officeCode" value="${officeToUp.officeCode}">
        <table>
            <tr>
                <td><span class="ass">*</span> City</td>
                <td><input type="text" disabled value="${officeToUp.city}"></td>
                <td>===></td>
                <td><input name="newCity" type="text" value="${badInputs != null ? badInputs[0] : officeToUp.city}"></td>
            </tr>
            <tr>
                <td><span class="ass">*</span> Phone</td>
                <td><input type="text" disabled value="${officeToUp.phone}"></td>
                <td>===></td>
                <td><input name="newPhone" type="text" value="${badInputs != null ? badInputs[1] : officeToUp.phone}"></td>
            </tr>
            <tr>
                <td><span class="ass">*</span> Address 1</td>
                <td><input type="text" disabled value="${officeToUp.addressLine1}"></td>
                <td>===></td>
                <td><input name="newAddressLine1" type="text" value="${badInputs != null ? badInputs[2] : officeToUp.addressLine1}"></td>
            </tr>
            <tr>
                <td>Address 2</td>
                <td><input type="text" disabled value="${officeToUp.addressLine2}"></td>
                <td>===></td>
                <td><input name="newAddressLine2" type="text" value="${badInputs != null ? badInputs[3] : officeToUp.addressLine2}"></td>
            </tr>
            <tr>
                <td>State</td>
                <td><input type="text" disabled value="${officeToUp.state}"></td>
                <td>===></td>
                <td><input name="newState" type="text" value="${badInputs != null ? badInputs[4] : officeToUp.state}"></td>
            </tr>
            <tr>
                <td><span class="ass">*</span> Country</td>
                <td><input type="text" disabled value="${officeToUp.country}"></td>
                <td>===></td>
                <td><input name="newCountry" type="text" value="${badInputs != null ? badInputs[5] : officeToUp.country}"></td>
            </tr>
            <tr>
                <td><span class="ass">*</span> Postal Code</td>
                <td><input type="text" disabled value="${officeToUp.postalCode}"></td>
                <td>===></td>
                <td><input name="newPostalCode" type="text" value="${badInputs != null ? badInputs[6] : officeToUp.postalCode}"></td>
            </tr>
            <tr>
                <td><span class="ass">*</span> Territory</td>
                <td><input type="text" disabled value="${officeToUp.territory}"></td>
                <td>===></td>
                <td><input name="newTerritory" type="text" value="${badInputs != null ? badInputs[7] : officeToUp.territory}"></td>
            </tr>
        </table>
        <input type="submit">
    </form>
</c:if >
<c:if test="${errors != null}">
    <c:forEach var="error" items="${errors}">
        <p class="error">${error}</p>
    </c:forEach>
</c:if>
<c:if test="${message != null}">
        <p class="message">${message}</p>
</c:if>
</body>
</html>
