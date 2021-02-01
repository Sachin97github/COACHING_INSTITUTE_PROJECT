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
      <%@include file="/WEB-INF/pages/style/dataTable.css"%>
      <%@include file="/WEB-INF/pages/style/footerStyle.css"%>
      <%@include file="/WEB-INF/pages/style/adminPanel.css"%>
    </style>
</head>
<body>
   <%@include file="/WEB-INF/pages/home-sample.html"%>
  <div class="container">
      <diiv class="admin-controls-container">
      <h2>Panel</h2>      
      <a class="link" href="courses.htm"><button type="submit" class="admin-control-button">Course</button><a></a>
      <a class="link" href="faculties.htm"><button type="submit" class="admin-control-button">Faculty</button></a>
      <a class="link" href="staffMembers.htm"><button type="submit" class="admin-control-button">Staff</button></a>
      <a class="link" href="students.htm"><button type="submit" class="admin-control-button">Student</button></a>
    </diiv>
      <h2 class="headings">Students Information</h2>
      <div class="table-container">
       <c:choose>
   <c:when test="${not empty studentList || not null}">
     <table class="data">
       <tr>
         <th>Serial no</th> 
         <th>Id</th> 
        <th>Name</th> 
        <th>Email </th> 
        <th>Contact </th>  
        <th>Address</th>
        <th>Join Date</th>
        <th>Birth Date</th>
        <th>Action</th>
    </tr>
      <c:forEach var="student"  items="${studentList}" varStatus="counter">
          <tr>
          <td>${ counter.index+1}</td>
           <td>${ student.id}</td>
           <td>${ student.name}</td>
           <td>${ student.email}</td>
            <td>${ student.contact}</td>
           <td>${ student.address}</td>
          <td>${ student.doj}</td>
          <td>${ student.dob}</td>
          <td><a href="studentDelete.htm?staffId=${student.id}" class="action-links" >Delete</a>
               <a href="studentEdit.htm?staffId=${student.id}" class="action-links" >Edit</a>
          </td>
           </tr>	
      </c:forEach>
      </table>
   </c:when>
   <c:otherwise>
   <h2 class="headings">
      No Student Available at the moment......
    </h2>
   </c:otherwise>
</c:choose>	
         </div> <!-- table Container -->
 <a class="link" href="studentAdd.htm"> <button type="submit" class="admin-control-button">Add Student</button></a>
    </div> <!-- container -->
   <%@include file="/WEB-INF/pages/footer.html"%>
</body>
</html>









