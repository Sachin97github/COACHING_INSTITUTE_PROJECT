 <!-- <%@ page language="java"  isELIgnored="false" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<html>
<head>

   <link rel="stylesheet" >
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet"/>
  <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap" rel="stylesheet"> 
 <style>
      <%@include file="/WEB-INF/pages/style/formStyle.css"%>
       <%@include file="/WEB-INF/pages/style/navBar.css"%>
      <%@include file="/WEB-INF/pages/style/imageSlider.css"%>
      <%@include file="/WEB-INF/pages/style/bodyStyle.css"%>
      <%@include file="/WEB-INF/pages/style/homeStyle.css"%>
        <%@include file="/WEB-INF/pages/style/dataTableStyle.css"%>
    </style>
  <script src="js/imageSliderJs.js"></script> 
  </head>
<body>
    <div class="main-home-container">
        <h2 class="headings">
            Coaching Institute
        </h2>
        <ul class="nav-ul">
            <li ><a class="active" href="home.htm">Home</a></li>
            <li><a href="courseShowAll.htm">Course</a></li>
            <li><a href="facultyShowAll.htm">Faculty</a></li>
            <li><a href="studentAdd.htm">Student</a></li>
            <li><a href="about.htm">about</a></li>
          </ul>
    </div> <!--Heading-navigation container-->
<div class="container">
    <div class="slider">
      <span id="slide-1"></span>
      <span id="slide-2"></span>
      <span id="slide-3"></span>
      <div class="image-container">
      <c:url value="/files/korali.jpg">
        <img src="/WEB-INF/pages/images/img2.jpg" class="slide" width="500" height="300" />
        <img src='<c:url value="/pages/images/img2.jpg"></c:url>' class="slide" width="500" height="300" />
        <img src="images/image2.webp" class="slide" width="500" height="300" />
      </div>
      <div class="buttons">
        <a href="#slide-1"></a>
        <a href="#slide-2"></a>
        <a href="#slide-3"></a>
      </div>
    </div> <!--Slider--> 
     <p class="home-paragraph"> Our Institution is best for Software Training in Java,Php,Python,C,C++,Oracle,
       <br>and Other Frameworks and Technologies
        .we have Experience over 10+ year  thousands of statisfied
       <br> student over the india.
     </p>
     <h3 class="home-content-headings">Register Yourself</h3>
    <form action="studentAdd.htm"> <button type="submit" class="button button2">Become a Student</button>
    </form>
   
    <h2 class="headings">Upcoming Course</h2>
   <c:choose>
   <c:when test="${not empty courseList || not null}">
     <table class="data-table">
       <tr>
         <th>Course Id</th> 
        <th>Name</th> 
        <th>Start Date </th>  
        <th>Price</th>
        <th>Faculty</th>
    </tr>
      <c:forEach var="course"  items="${courseList}">
          <tr><td>${ course.id}</td><td>${ course.name}</td><td>${ course.startDate}</td><td>${ course.price}</td><td>${ course.facultyDTO.name}</td></tr> 
      </c:forEach>
   </c:when>
   <c:otherwise>
   <h2 class="headings">
      No Courses Available at the moment......
    </h2>
   </c:otherwise>
</c:choose>

  </div> <!-- table Container-->
  <footer>
     <div class="footer-div">
            <div class="footer-left-div">
                Address <hr>
                Gadarwara,Narsinghpur<br>
                Bhopal MP<br>
                Pin Code : 48755 <br>
                Contact <hr>
                +91-7697019105         
            </div>
            <div class="footer-right-div">
              Follow us<hr>
              <a  href="https://www.facebook.com/sachin7697/">
                <img src="images/facebook.webp" alt="loading.." style="width:42px;height:42px;">
                </a> 
                <a href="#">
                  <img src="images/twitter.webp" alt="loading.." style="width:42px;height:42px;">
                  </a> 
                  <a href="#">
                    <img src="images/instagram.webp"  alt="loading.." style="width:42px;height:42px;">
                    </a> 
                    
          </div>
     </div>
  </footer> 
</body>
</html>