<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css" />

<p><a href="/FirstSpringMVCProject/admissionForm.html?siteTheme=green">Green</a>|
	<a href="/FirstSpringMVCProject/admissionForm.html?siteTheme=red">Red</a></p>

<h1>${msg}</h1>

	<form:errors path="student1.*"/>

<form action="/FirstSpringMVCProject/submitAdmissionnForm.html" method="post">
<table>
<tr><td>
Student Name: </td><td><input type="text" name = "studentName"/></td></tr>

<tr><td>Hobby: </td><td><input type="text" name = "studentHobby"/></td></tr>

<tr><td>Student Mobile: </td><td><input type="text" name="studentMobile"/> </td></tr>
<tr><td>Student DOB: </td><td><input type="text" name="studentDOB"></td></tr>
<tr><td>Student Skill Set: </td><td><select name="studentSkills" multiple="multiple">
										<option value="Standard Java">Standard Java</option>
										<option value="Spring Framework">Spring Framework</option>
										<option value="Struts Framework">Struts Framework</option>
										<option value="Hibernate">Hibernate</option>

									</select> </td></tr>
									
									
<tr><td>Sturdent Country:</td><td><input type="text" name="studentAddress.country" /></td></tr>
<tr><td>Student City:</td><td><input type="text" name="studentAddress.city" /></td></tr>
<tr><td>Student Street:</td><td><input type="text" name="studentAddress.street" /></td></tr>
<tr><td>Student Pincode:</td><td><input type="text" name="studentAddress.pincode" /></td></tr>


<tr><td><input type="submit"></td>></tr>
</table>

</form>

</body>
</html>