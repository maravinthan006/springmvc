<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"
          uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<form action="supplieradd" method="post">
 <center>
 <h2><b>Supplier Details</b></h2>

    <br><label><b>Id</b></label>
    <input type="text" value="${value.id}"name="id"/><br>
    
    <br><label><b>Name</b></label>
    <input type="text" value="${value.name}" name="name"><br>
  
    <br><label><b>ContactNumber</b></label> 
    <input type="text" value="${value.contactnumber}"name="contactnumber"/><br>
    
     <br><input type="submit" id="add" name="add" value="Add">
     </center>
     <center>
<h1>supplier table</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Contactnumber</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="supplier" items="${supplierList}">   
   <tr>  
   <td>${supplier.id}</td>  
   <td>${supplier.name}</td>   
   <td>${supplier.contactnumber}</td>  
   <td><a href="editsupplier?supplierId=${supplier.id}">Edit</a></td>  
   <td><a href="deletesupplier?supplierId=${supplier.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table> 
   </center> 
   <br/>  
</form>
</body>
</html>