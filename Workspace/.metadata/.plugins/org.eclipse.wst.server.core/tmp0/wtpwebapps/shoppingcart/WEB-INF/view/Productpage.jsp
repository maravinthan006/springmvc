<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Header.jsp"/>

</head>
<body>
<div class="container">

<img src="resources/images/${productlist.id}.png" alt="${productlist.id}" style="width:150px:heigth:150px">
<br>
<strong>Product name:</strong> ${productlist.name}<br>
<strong>Product description: </strong>${productlist.description}<br>
<strong>Price: </strong>${productlist.price}<br>
<h2><a href="addtocart">Add to cart</a></h2>

</div>

</body>
</html>
