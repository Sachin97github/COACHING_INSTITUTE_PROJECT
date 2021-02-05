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
    </style>
  </head>

<body>
   
  
   <%@include file="/WEB-INF/pages/home-sample.jsp"%>
  <div class="container">
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
    </div>
   <%@include file="/WEB-INF/pages/footer.html"%>
</body>
</html>




