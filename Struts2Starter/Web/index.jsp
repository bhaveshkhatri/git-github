<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- <form action="tutorials/getTutorial.action" method="post">

<input type="text" name="language" />
<input type="submit" />

</form> -->

<s:form action="tutorials/getTutorial">
<s:property value="userId"/>
<s:textfield label="Enter the  language u want to search " key="language" />
<s:submit/>
</s:form>

</body>
</html>