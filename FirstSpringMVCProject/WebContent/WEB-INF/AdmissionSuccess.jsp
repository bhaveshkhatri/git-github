<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${msg}</h1>

<table>
<tr>
	<td>Student Name: </td>
	<td>${student1.studentName}</td>
</tr>

<tr>
	<td>Student Hobby: </td>
	<td>${student1.studentHobby}</td>
</tr>

<tr>
	<td>Student Mobile:</td>
	<td>${student1.studentMobile}</td>
</tr>

<tr>
	<td>Student DOB:</td>
	<td>${student1.studentDOB}</td>
</tr>

<tr>
	<td>Student Skills:</td>
	<td>${student1.studentSkills}</td>
</tr>

<tr>
	<td>Student Country:</td>
	<td>${student1.studentAddress.country}</td>
</tr>

<tr>
	<td>Student City:</td>
	<td>${student1.studentAddress.city}</td>
</tr>

<tr>
	<td>Student Street:</td>
	<td>${student1.studentAddress.street}</td>
</tr>

<tr>
	<td>Student Pincode:</td>
	<td>${student1.studentAddress.pincode}</td>
</tr>


</table>

</body>
</html>