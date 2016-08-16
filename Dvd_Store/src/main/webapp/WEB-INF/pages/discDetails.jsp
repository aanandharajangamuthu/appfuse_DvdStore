<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Disc Detail</title>
</head>
<body>
    <center>
    <br><br><br><br><br><br>
    <div style="color: green;font-size: 30px">Disc Details</div>
    <br><br>
    <c:if test="${!empty disc}">
        <table border="1" bgcolor="black" width="600px">
        <tr style="background-color: green;color: white;text-align: center;" height="40px">
            <td>Disc Movie Name</td>
            <td>Director</td>
            <td>Actor</td>
            <td>Image</td>
            <td>Price</td>
            <td>Stock</td>
            <td>Buy</td>
            <td></td>
        </tr>  
        <c:forEach items="${disc}" var="disc">
            <form:form id="discId" modelAttribute="cart" method="post" action="buyDisc.html">
                <tr style="background-color:white;color: black;text-align: center;" height="30px" >
                   <input type="hidden" id="id" name="id" value="${disc.id}"/>
                    <td><c:out value="${disc.name}"/></td>
                    <td><c:out value="${disc.directorName}"/></td>
                    <td><c:out value="${disc.actorName}"/></td>
                    <td><img src="images/<c:out value="${disc.imageUrl}"/>" alt="image" border=3 height=100 width=100></img></td>
                    <td><c:out value="${disc.price}"/></td>
                    <td><c:out value="${disc.stock}"/></td>
                    <td><input type="submit" value="buy"></td>
                </tr>
            </form:form>
        </c:forEach>
    </table>
    </c:if>
</center>
</body>
</html>