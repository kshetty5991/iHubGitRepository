<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
</head>
<body>
<div align="center">
    <h2>Search Result</h2>
    <table border="1" cellpadding="5">
        <c:if test="${not empty result}">
       	<tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Discount</th>
            <th>Delivery Charge</th>
            <th>Average rating</th>
            <th>Seller Name</th>
        </tr>
        
        <c:forEach items="${result}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.discount}</td>
            <td>${product.deliverycharge}</td>
            <td>${product.avgrating}</td>
            <td>${product.sellername}</td>
            <td>
                <a href="/cart">BUY</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/wish?id=${product.id}">Add to Wishlist</a>
            </td>
        </tr>
        </c:forEach>
        </c:if>
        <c:if test="${empty result}">
        <h2 style="color:red;">Sorry, no products found</h2>
        </c:if>
    </table>
   </br>
   </br>
                <a href="/shop">Continue Shopping</a>
</div>   
</body>
</html>