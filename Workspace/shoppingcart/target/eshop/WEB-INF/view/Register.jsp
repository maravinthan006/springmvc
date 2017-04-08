<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Register</title>
</head>
<body>
<form action="registersave" method="post">
<center>
<h2><b>Registration page</b></h2>
    <label><b>Name</b></label><br>
    <input type="text" name="name"><br>
  
    <br><label><b>UserName</b></label><br>
    <input type="text" name="username"/><br>
    
     <br><label><b>Password</b></label><br>
    <input type="password" name="password"/> <br>
    
    <br><label><b>Address</b></label> <br>
    <input type="text" name="address"/><br>
    
     <br><label><b>EmailId</b></label><br>
    <input type="text" name="email"><br>
    
      <br><label><b>MobileNumber</b></label><br>
    <input type="text" name="mobilenumber"><br>
    
     <br><input type="submit" id="add" name="operation" value="Add">
     
     </center>
  </form>
</body>
</html>