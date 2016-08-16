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
        <li><a href="login.html">${pageContext.request.remoteUser}</a></li>
        <li><a href="cartList.html">CART</a></li>
      </ul>
    </div>
    <div id="sub-navigation">
    <ul>
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
  <div id="main">
    <div id="content">
      <div class="box">
        <div class="movie">
          <div class="movie-image"> <span class="play"><span class="name">Theri</span></span><a href="tamilMovies.html"><img src="images/vijay.jpeg" alt="" /></a></div>
          <div class="rating">
            <p>RATING</p>
            <div class="stars">
              <div class="stars-in"> </div>
            </div>
            <span class="comments">12</span> </div>
        </div>
        <div class="movie">
          <div class="movie-image"> <span class="play"><span class="name">300 Spartans</span></span> <a href="englishMovies.html"><img src="images/spartan.jpeg" alt="" /></a> </div>
          <div class="rating">
            <p>RATING</p>
            <div class="stars">
              <div class="stars-in"> </div>
            </div>
            <span class="comments">12</span> </div>
        </div>
        <div class="movie">
          <div class="movie-image"> <span class="play"><span class="name">3 Idiots</span></span> <a href="hindiMovies.html"><img src="images/idiots.jpeg" alt="" /></a> </div>
          <div class="rating">
            <p>RATING</p>
            <div class="stars">
              <div class="stars-in"> </div>
            </div>
            <span class="comments">12</span> </div>
        </div>
        <div class="movie">
          <div class="movie-image"> <span class="play"><span class="name">Aym</span></span> <a href="tamilSongs.html"><img src="images/aym.jpeg" alt="" /></a> </div>
          <div class="rating">
            <p>RATING</p>
            <div class="stars">
              <div class="stars-in"> </div>
            </div>
            <span class="comments">12</span> </div>
        </div>
        <div class="movie">
          <div class="movie-image"> <span class="play"><span class="name">Beautiful</span></span> <a href="englishSongs.html"><img src="images/eminem.jpeg" alt="" /></a> </div>
          <div class="rating">
            <p>RATING</p>
            <div class="stars">
              <div class="stars-in"> </div>
            </div>
            <span class="comments">12</span> </div>
        </div>
        <div class="movie">
          <div class="movie-image"> <span class="play"><span class="name">Mohenja Tharo</span></span> <a href="hindiSongs.html"><img src="images/mohenja.jpeg" alt="" /></a> </div>
          <div class="rating">
            <p>RATING</p>
            <div class="stars">
              <div class="stars-in"> </div>
            </div>
            <span class="comments">12</span> </div>
        </div>
        <div class="movie last">
          <div class="movie-image"> <span class="play"><span class="name">Neeya Naana</span></span> <a href="tamilShows.html"><img src="images/neeyanaana.jpeg"" alt="" /></a> </div>
          <div class="rating">
            <p>RATING</p>
            <div class="stars">
              <div class="stars-in"> </div>
            </div>
            <span class="comments">12</span> </div>
        </div>
        <div class="cl">&nbsp;</div>
      </div>      
</div>
</div>
</body>
</html>