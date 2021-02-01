 <%@ page language="java"  isELIgnored="false" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
   <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300&display=swap" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css2?family=Fredoka+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap" rel="stylesheet"> 
    <link rel="preconnect" href="https://fonts.gstatic.com">
 <style>
      <%@include file="/WEB-INF/pages/style/homeStyle.css"%>
      <%@include file="/WEB-INF/pages/style/container.css"%>
      <%@include file="/WEB-INF/pages/style/footerStyle.css"%>
      <%@include file="/WEB-INF/pages/style/adminPanel.css"%>
    </style>
</head>
<body>
   <%@include file="/WEB-INF/pages/home-sample.html"%>
  <div class="container">
         <diiv class="admin-controls-container">
      <h2> Admin Panel</h2>      
      <a class="link" href="courses.htm"><button type="submit" class="admin-control-button">Course</button><a></a>
      <a class="link" href="faculties.htm"><button type="submit" class="admin-control-button">Faculty</button></a>
      <a class="link" href="staffMembers.htm"><button type="submit" class="admin-control-button">Staff</button></a>
      <a class="link" href="students.htm"><button type="submit" class="admin-control-button">Student</button></a>
    </diiv>
    </div> <!-- container -->
   <%@include file="/WEB-INF/pages/footer.html"%>
</body>
</html>









