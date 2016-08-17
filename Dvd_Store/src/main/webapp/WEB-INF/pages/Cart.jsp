<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cart Detail</title>
    <link rel="stylesheet" type="text/css" href="dvdStyle.css">
</head>
<body>
    <center>
        <br><br><br>
        <p style="color:#000;font-size:25px">Total Amount : <c:out value="${totalAmount}Rs"/></p>
        <br><br><br>
        <div style="color: green;font-size: 30px">Cart Details</div>
        <br><br>
        <c:if test="${!empty cart}">            
        <table border="1" bgcolor="black" width="600px">
            <tr style="background-color: green;color: white;text-align: center;" height="40px">          
                <td>Movie Name</td>
                <td>Director</td>
                <td>Poster</td>
                <td>Quantity</td>
                <td>Total price<td>
            </tr>
            <c:forEach items="${cart}" var="cart">
                <form:form id="cartId" method="post" action="deleteCart.html">
                <input type="hidden" id="discId" name="discId" value="${cart.disc.getId()}"/>
                <input type="hidden" id="id" name="id" value="${cart.id}"/>
                    <tr style="background-color:white;color: black;text-align: center;" height="30px" >
                        <td><c:out value="${cart.disc.getName()}"/></td>
                        <td><c:out value="${cart.disc.getDirectorName()}"/></td>
                        <td><img src="images/<c:out value="${cart.disc.getImageUrl()}"/>" alt="image" border=3 height=100 width=100></img></td>
                        <td><input type="hidden" id="quantity" name="quantity" value="${cart.quantity}"/>${cart.quantity}</td>
                        <td><c:out value="${cart.totalPrice}"/></td>
                        <td><input type="submit" value="Delete"></td> 
                    </tr>
                </form:form>
            </c:forEach>
        </table>
        <br><br>
        <a href="purchaseDisc.html" target="iframe_a"><input type="button" class="button" value="Purchase"></a><br>
       </c:if>
       <br>
    </center>
</body>
</html>