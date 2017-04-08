<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c"
          uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category_ShoppingCart</title>
</head>
<body>

<form action="adding" method="post">
 <center>
 <h2><b>Category Details</b></h2>
 
     <br><label><b>Id</b></label>
    <input type="text" name="id" value="${values.id}"><br>
    
    <br><label><b>Name</b></label>
    <input type="text" name="name" value="${values.name}"><br>
  
    <br><label><b>Description</b></label> 
    <input type="text" name="description" value="${values.description}"><br>
   
     <br><input type="submit" id="add" name="add" value="Add">
     
    </center>
     <br>
     <center>
 <h1>category table</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Description</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="category" items="${categoryList}">   
   <tr>  
   <td>${category.id}</td>  
   <td>${category.name}</td>   
   <td>${category.description}</td>  
   <td><a href="editcategory?categoryId=${category.id}">Edit</a></td>  
   <td><a href="deletecategory?categoryId=${category.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>
   </center>
   </form>
    
  
 </body>
</html>