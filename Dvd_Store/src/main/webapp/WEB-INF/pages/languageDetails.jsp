<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Language Details</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: green;font-size: 30px">Language Details</div>
<br><br>
<c:if test="${!empty language}">
<table border="1" bgcolor="black" width="600px">
<tr style="background-color: green;color: white;text-align: center;" height="40px">
<td>Language Id</td>
<td>Language Name</td>
</tr>
<c:forEach items="${language}" var="language">
<tr style="background-color:white;color: black;text-align: center;" height="30px" >
<td><c:out value="${language.id}"/></td>
<td><c:out value="${language.name}"/></td>
</tr>
</c:forEach>
</table>
</c:if>
<br>
<a href="registerLanguage.html" >Click Here to add new Language</a>
</center>
</body>
</html>