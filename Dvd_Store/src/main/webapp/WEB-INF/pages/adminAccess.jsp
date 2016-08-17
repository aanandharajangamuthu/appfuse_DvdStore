<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin access</title>
    <link rel="stylesheet" type="text/css" href="dvdStyle.css">
</head>
 <body bgcolor="black">
     <div id="shell">
     <div id="header"> 
         <h1 id="logo"><a href="#">Fact</a></h1>
         <i><h2 style="color:green">Be a Fanatic and Admire Everything </h2></i>
     </div>
     <div id="newNavigation">
         <ul>
             <li><a href="registerLanguage.html" target="iframe_admin">Register Language</a></li>
             <li><a href="languageList.html" target="iframe_admin">List of Languages</a></li>
             <li><a href="assignLanguage.html" target="iframe_admin">Assign Language</a></li>
             <li><a href="assignCategory.html" target="iframe_admin">Assign Category</a></li>
             <li><a href="registerCategory.html" target="iframe_admin">Register Category</a></li>
             <li><a href="categoryList.html" target="iframe_admin">List of Categories</a></li>
         </ul>
     </div>
     <div id="sub_newNavigation">
         <ul>
             <li><a href="registerDisc.html" target="iframe_admin">Register Disc</a></li>
             <li><a href="discList.html" target="iframe_admin">List of Discs</a></li>
             <li><a href="userList.html" target="iframe_admin">List of Users</a></li>
             <li><a href="cartList.html" target="iframe_admin">Cart</a></li>
             <li><a href="home.html">Home</a></li>
             <li><a href="#">${pageContext.request.remoteUser}</a></li>
         </ul>
     </div>
       <iframe frameborder="0"  allowtransparency="yes" scrolling="yes" height="500px" width="100%"  name="iframe_admin" style="border:none";></iframe>
</body>
</html>