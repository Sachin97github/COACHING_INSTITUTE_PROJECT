<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="style/formStyle.css"></link>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet"/>
  
  <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap" rel="stylesheet"> 
  <style><%@include file="/WEB-INF/pages/style/navBar.css"%>
      <%@include file="/WEB-INF/pages/style/formStyle.css"%>
         <%@include file="/WEB-INF/pages/style/dataTableStyle.css"%>
  </style>
  </head>
<body>

<div class="main-home-container">
        <h2 class="headings">
            Coaching Institute
        </h2>
        <ul class="nav-ul">
         <li ><a href="home.htm">Home</a></li>
            <li><a href="courseShowAll.htm">Course</a></li>
            <li><a class="active"  href="facultyShowAll.htm">Faculty</a></li>
            <li><a href="studentAdd.htm">Student</a></li>
            <li><a href="about.htm">about</a></li>
        </ul>
    </div> <!--Heading-navigation container-->

<div class="container">
<h2 class="headings">Upcoming Course</h2>
   <c:choose>
   <c:when test="${not empty courseList || not null}">
     <table class="data-table">
       <tr>
         <th>Course Id</th> 
        <th>Name</th> 
        <th>Subject </th>  
        <th>Email</th>
        <th>Address</th>
        <th>Contact</th>
        <th>Joining Date</th>
    </tr>
      <c:forEach var="faculty"  items="${facultyList}">
          <tr><td>${ faculty.id}</td><td>${ faculty.name}</td><td>${ faculty.subject}</td><td>${ faculty.email}</td><td>${ faculty.address}</td>
            <td>${ faculty.contact}</td><td>${ faculty.doj}</td>
          </tr> 
      </c:forEach>
   </c:when>
   <c:otherwise>
   <h2 class="headings">
      No Courses Available at the moment......
    </h2>
   </c:otherwise>
</c:choose>
</div>
</body>
</html>