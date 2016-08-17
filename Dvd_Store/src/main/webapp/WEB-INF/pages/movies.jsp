<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Disc Detail</title>
    <link rel="stylesheet" type="text/css" href="dvdStyle.css">
</head>
<body>
    <div id="shell">
        <div align="center" style="color: green;font-size: 30px">Available Movies</div>
        <br><br>
        <c:if test="${!empty disc}">
            <c:forEach items="${disc}" var="disc">
                <form:form id="discId" method="post" action="buyDisc.html">
                    <c:if test="${disc.category.getId() == 5}">
                        <div class="upleft">
                            <img src="<c:out value="${disc.imageUrl}"/>" alt="image" border=3 height=200 width=200></img>
                        </div>
                        <div style="color:green;font-size:120%">
                            <p><input type="hidden" id="id" name="id" value="${disc.id}"/></p>
                            <i><strong><p> Movie: <c:out value="${disc.name}"/></p><strong></i>
                        </div>
                        <div style="color:white">
                            <p> Director: <c:out value="${disc.directorName}"/><p>
                            <p> Actor: <c:out value="${disc.actorName}"/></p>
                            <p> Price: <c:out value="${disc.price}"/></p>
                            <p> Stock: <c:out value="${disc.stock}"/></p>
                            <p><input type="submit" class="buy" value="Buy"/><p>
                       </div>
                   </c:if>
               </form:form>
           </c:forEach>
        </c:if>
    </div>
</body>
</html>