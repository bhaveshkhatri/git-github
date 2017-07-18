<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="filter" method="post">
	<table>
		<tr><td>Login ID: </td><td><input type="text" name = "id"/></td> </tr>
		<tr><td>Password: </td><td><input type="text" name = "pwd"/></td> </tr>
		<tr><td> <button type="submit" >Submit</button></td></tr>
		<tr><td><a href="registration.jsp">Don't have an account?</a></td></tr>
	</table>
</form>

</body>
</html>