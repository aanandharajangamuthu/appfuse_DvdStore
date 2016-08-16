<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Category Registration</title>
</head>
<body>
    <center>
    <br><br><br><br><br><br>
    <div style="color: green;font-size: 30px">Disc Details</div>
    <br><br>
    <br><br>
    <div style="color: green;font-size: 30px">Language for Disc</div>
    <br><br>
    <form method="post" action="allocateLanguage.html">
    <table width="400px" height="150px">
        <tr>
            <td style="color:white">Disc Id</td>
            <td><input type="text" name="discId" /></td>
        </tr>
        <tr>
            <td style="color:white">Language Id</td>
            <td><input type="text" name="languageId"/></td>
        </tr>
        <tr><td></td><td>
            <input type="submit" value="Submit" />
        </td></tr>
    </table>
    </form>
    <br>
    </center>
</body>
</html>