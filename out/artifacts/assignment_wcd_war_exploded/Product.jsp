<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 15/11/2021
  Time: 7:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    table, th, td {
        border:1px solid black;
    }
</style>
<body>
<table style="width:100%">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>amount</th>
        <th>price</th>
        <th>details</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.amount}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.details}"/></td>
        </tr>
    </c:forEach>
</table>

<a href="/ProductServlet" class="item" data-toggle="tooltip" data-placement="top" role="button"
   title="Edit">
    <button type="button">
        Logout
    </button>
</a>


</body>
</html>
