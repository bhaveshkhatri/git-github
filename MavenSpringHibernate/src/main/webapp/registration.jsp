<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:: Sign Up ::</title>
</head>
<body>
<form action="registration" method="post">
<table>
<tr><td>Please register....</td></tr>
<tr><td><br></td></tr>
<tr><td>First Name: </td><td><input type="text" name="firstName" style="width:180px"/></td></tr>
 
<tr><td>Last Name: </td><td><input type="text" name="lastName" style="width:180px"/></td></tr>

<tr><td>Email ID: </td><td><input type="text" name="email" style="width:180px"/></td></tr>

<tr><td>Password: </td><td><input type="password" name="password" style="width:180px"/></td></tr	>

<tr><td>Confirm Password: </td><td><input type="password" name="pwd" style="width:180px"/></td></tr>

<tr><td>Birthday: </td>
<!-- <td><select id="month">
		<option>--Select--</option><option value="January">January</option><option value="February">February</option><option value="March">March</option><option value="April">April</option><option value="May">May</option><option value="June">June</option><option value="July">July</option><option value="August">August</option><option value="September">September</option><option value="October">October</option><option value="November">November</option><option value="December">December</option>
	</select> &nbsp; <input type="text" name="day" style="width:20px" /> &nbsp; <input type="text" name="year" style="width:35px"/> </td></tr> -->

	<td><input type="text" name="dob" style="width:180px"/></td>
	</tr>


<tr><td>Gender: </td><td>

<input type="radio" name="gender" value="Male"> Male</input>
<input type="radio" name="gender" value="Female"> Female</input>
<input type="radio" name="gender" value="Other"> Other</input>
</td></tr>


<tr><td>Mobile No.: </td><td><input type="text" name="phone" style="width:180px" /></td></tr>

<tr><td colspan="2" align="right"><input type="submit" value="SUBMIT" /></td></tr>

</table>
</form>
</body>
</html>