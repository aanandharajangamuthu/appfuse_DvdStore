<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
 function check_qty() {
     var requiredQuantity = Number(document.getElementById('quantity').value);
     var availableQuantity = Number(document.getElementById('stock').value);
     if((requiredQuantity <= availableQuantity) && (requiredQuantity < 0)) {
    	 alert("Enter from 1 to Available Quantity. Available Quantity: "+availableQuantity);
    	 return false;
     } else if((requiredQuantity <= availableQuantity) && (requiredQuantity > 0)) {
    	 return true;
     } else {	 
    	 alert("Quantity exceeds. Available Quantity: "+availableQuantity);
         return false;
     }
 }
</script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Disc Detail</title>
    <link rel="stylesheet" type="text/css" href="dvdStyle.css">
</head>
<body>
    <div id="shell">
        <div align="center" style="color: green;font-size: 30px">Buy Disc</div>
        <br><br>
        <c:if test="${!empty BuyDisc}">
            <form:form id="discId" modelAttribute="cart" method="post" onsubmit="return check_qty()" action="addProduct.html">
            <div class="upleft">
                <img src="images/<c:out value="${BuyDisc.imageUrl}"/>" alt="image" border=3 height=200 width=200></img>
            </div>
            <div style="color:green;font-size:120%">
                <p><input type="hidden" id="id" name="id" value="${BuyDisc.id}"/></p>
                <p><input type="hidden" id="userName" name="userName" value="${pageContext.request.remoteUser}"/></p>
                <i><strong><p><c:out value="${BuyDisc.name}"/></p><strong></i>
            </div>
            <div style="color:white">
                <p> Director: <c:out value="${BuyDisc.directorName}"/><p>
                <p> Actor: <c:out value="${BuyDisc.actorName}"/></p>
                <p><input type="hidden" id="stock" name="stock" value="${BuyDisc.stock}"/>
                <p> Stock: <c:out value="${BuyDisc.stock}"/></p>
                <p> Price: <c:out value="${BuyDisc.price}"/></p>
                <p> quantity: <input required="required" type="text" class="quantity" id="quantity" name="quantity"/><p>
                <p><input type="submit" class="addCart" value="Add to Cart"/><p>
            </div>
            </form:form>
        </c:if>
    </div>
</body>
</html>