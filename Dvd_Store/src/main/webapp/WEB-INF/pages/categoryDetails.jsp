<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Category Details</title>
</head>
<body>
    <center>
    <br><br><br><br><br><br>
        <div style="color: green;font-size: 30px">Category Details</div>
        <br><br>
        <c:if test="${!empty category}">
            <table border="1" bgcolor="black" width="600px">
                <tr style="background-color: green;color: white;text-align: center;" height="40px">
                    <td>Category Id</td>
                    <td>Category Name</td>
                </tr>
            <c:forEach items="${category}" var="category">
                <tr style="background-color:white;color: black;text-align: center;" height="30px" >
                    <td><c:out value="${category.id}"/></td>
                    <td><c:out value="${category.name}"/></td>
               </tr>
            </c:forEach>
            </table>
        </c:if>
        <br>
        <a href="registerCategory.html" >Click Here to add new Category</a>
    </center>
</body>
</html>