<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pluem
  Date: 12/16/2023
  Time: 11:47 AM
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
<h1>Create a New Office</h1>
<a href="index.jsp">To Home</a> > <a href="OfficeMenu">Office Menu</a> > CreateOffice
<hr>
<form action="CreateOffice" method="post">
  <table>
    <tr>
      <td><span class="ass">*</span> Office Code</td>
      <td><input type="text" name="newOfficeCode" value=${badInputs != null ? badInputs[0] : ""}></td>
    </tr>
    <tr>
      <td><span class="ass">*</span> City</td>
      <td><input type="text" name="newCity" value=${badInputs != null ? badInputs[1] : ""}></td>
    </tr>
    <tr>
      <td><span class="ass">*</span> Phone</td>
      <td><input type="text" name="newPhone" value=${badInputs != null ? badInputs[2] : ""}></td>
    </tr>
    <tr>
      <td><span class="ass">*</span> Address 1</td>
      <td><input type="text" name="newAddressLine1" value=${badInputs != null ? badInputs[3] : ""}></td>
    </tr>
    <tr>
      <td>Address 2</td>
      <td><input type="text" name="newAddressLine2" value=${badInputs != null ? badInputs[4] : ""}></td>
    </tr>
    <tr>
      <td>State</td>
      <td><input type="text" name="newState" value=${badInputs != null ? badInputs[5] : ""}></td>
    </tr>
    <tr>
      <td><span class="ass">*</span> Country</td>
      <td><input type="text" name="newCountry" value=${badInputs != null ? badInputs[6] : ""}></td>
    </tr>
    <tr>
      <td><span class="ass">*</span> Postal Code</td>
      <td><input type="text" name="newPostalCode" value=${badInputs != null ? badInputs[7] : ""}></td>
    </tr>
    <tr>
      <td><span class="ass">*</span> Territory</td>
      <td><input type="text" name="newTerritory" value=${badInputs != null ? badInputs[8] : ""}></td>
    </tr>
  </table>
  <input type="submit">
</form>
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
