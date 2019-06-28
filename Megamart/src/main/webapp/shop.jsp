
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

        <h2>Welcome User, You are logged in.</h2>
<div align="center">
    <h2>Product List</h2>
    <form method="get" action="/search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>
    </br>
    <table border="1" cellpadding="5">
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
        <c:forEach items="${listProduct}" var="product">
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
                <a href="${pageContext.request.contextPath }/cart/buy/${product.id}">BUY</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/wish?id=${product.id}">Add to Wishlist</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
     <button onclick="document.forms['logoutForm'].submit()">Logout</button>
            </h3></u>

    <form id="logoutForm" method="POST" action="/logout">
    </form>

</body>	
</html>
