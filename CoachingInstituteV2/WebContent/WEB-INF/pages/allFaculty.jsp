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
   <%@include file="/WEB-INF/pages/home-sample.html"%>
  <div class="container">
   <h2 class="headings">Faculty Information</h2>
      <div class="table-container">
       <c:choose>
   <c:when test="${not empty facultyList || not null}">
     <table class="data">
       <tr>
        <th>Serial no</th> 
         <th>faculty</th> 
        <th>Name</th> 
        <th>Subject </th>  
        <th>Email</th>
    </tr>
      <c:forEach var="faculty"  items="${facultyList}" varStatus="counter">
							<tr>
							<td>${ counter.index+1}</td>
								<td>${ faculty.id}</td>
								<td>${ faculty.name}</td>
								<td>${ faculty.subject}</td>
								<td>${ faculty.email}</td>
							</tr>
						</c:forEach>
      </table>
   </c:when>
   <c:otherwise>
   <h2 class="headings">
      No Faculties Available at the moment......
    </h2>
   </c:otherwise>
</c:choose>	
         </div> <!-- table Container -->
    </div>
   <%@include file="/WEB-INF/pages/footer.html"%>
</body>
</html>









