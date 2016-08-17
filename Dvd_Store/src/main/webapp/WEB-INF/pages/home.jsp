<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Funtainment</title>
<link rel="stylesheet" type="text/css" href="dvdStyle.css">
</head>
 <body bgcolor="black">
 <div id="shell">
  <div id="header"> 
  <h1 id="logo"><a href="#">Fact</a></h1>
 <i><h2 style="color:green">Be a Fanatic and Admire Everything </h2></i>
 </div>
     <div id="navigation">
      <ul>   
        <li><div class = "dropdown"><a href="#">${pageContext.request.remoteUser}</a>  
        <div class="dropdown-content">
                <a href="login.html">Logout</a>
        </div></div></li>
        <li><a href="cartList.html" target="iframe_a">Cart</a></li>
      </ul>
    </div>
    <div id="sub-navigation">
    <ul>
    <li><a href="home.html">Home</a><li>
     <li><div class = "dropdown"><a href="movieList.html" target="iframe_a">Movies</a>
     <div class="dropdown-content">
       <a href="tamilMovies.html" target="iframe_a">Tamil</a>
       <a href="englishMovies.html" target="iframe_a">English</a>
       <a href="hindiMovies.html" target="iframe_a">Hindi</a>
     </div>
     </div>
     </li>
     <li><div class = "dropdown"><a href="songList.html" target="iframe_a">Songs</a>
     <div class="dropdown-content">
       <a href="tamilSongs.html" target="iframe_a">Tamil</a>
       <a href="englishSongs.html" target="iframe_a">English</a>
       <a href="hindiSongs.html" target="iframe_a">Hindi</a>
     </div>
     </div>
     </li>
     <li><div class="dropdown"> <a href="showList.html" target="iframe_a">Tv Shows</a>
     <div class="dropdown-content">
       <a href="tamilShows.html" target="iframe_a">Tamil</a>
       <a href="englishShows.html" target="iframe_a">English</a>
       <a href="hindiShows.html" target="iframe_a">Hindi</a>
     </div>
     </div>
     </li>
  </ul>
  </div>
  </div>
  <iframe frameborder="0"  allowtransparency="yes" scrolling="yes" height="500px" width="100%" src="userIndex.html" name="iframe_a" style="border:none";></iframe>
</body>
</html>