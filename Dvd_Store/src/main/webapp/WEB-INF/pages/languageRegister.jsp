<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Language Registration</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: green;font-size: 30px">Language Registration Form</div>
<br><br>
<c:url var="languageRegistration" value="saveLanguage.html"/>
<form:form id="languageForm" modelAttribute="language" method="post" action="${languageRegistration}">
<table width="400px" height="150px">
<tr>
<td><form:label style="color:white" path="name">Language Name</form:label></td>
<td><form:input  path="name"/></td>
</tr>
<tr><td></td><td>
<input type="submit" value="Register" />
</td></tr>
</table>
</form:form>
<br>
<a href="languageList.html" >Click Here to see Language List</a>
</center>
</body>
</html>