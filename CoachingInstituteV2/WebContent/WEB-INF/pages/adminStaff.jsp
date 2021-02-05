
<%@ page language="java" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<html>
<head>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@300&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Fredoka+One&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<style>
<%@include file="/WEB-INF/pages/style/homeStyle.css"%>
            <%@include file="/WEB-INF/pages/style/container.css"%>
        <%@include file="/WEB-INF/pages/style/dataTable.css"%>
       <%@include file="/WEB-INF/pages/style/footerStyle.css"%>
       <%@include file="/WEB-INF/pages/style/form.css"%> 
       <%@include file="/WEB-INF/pages/style/adminPanel.css"%> 
</style>
</head>
<body>

  
   <%@include file="/WEB-INF/pages/home-sample.jsp"%>
	<div class="container">
		 <diiv class="admin-controls-container">
      <h2>Panel</h2>      
     <a class="link" href="courses"><button type="submit" class="admin-control-button">Course</button><a></a>
      <a class="link" href="faculties"><button type="submit" class="admin-control-button">Faculty</button></a>
      <a class="link" href="staffMembers"><button type="submit" class="admin-control-button">Staff</button></a>
      <a class="link" href="students"><button type="submit" class="admin-control-button">Student</button></a>
     </diiv>
		
		<h2 class="headings">Staff Information</h2>
		<div class="table-container">
			<c:choose>
				<c:when test="${not empty staffList || not null }">
					<table class="data">
						<tr>
							<th>Serial no</th>
							<th>Staff Id</th>
							<th>Name</th>
							<th>Email</th>
							<th>Address</th>
							<th>Contact</th>
							<th>Dob</th>
							<th>Doj</th>							
							<th>Action</th>
						</tr>
						<c:forEach var="staff" items="${staffList}" varStatus="counter">
							<tr>
								<td>${ counter.index+1}</td>
								<td>${ staff.id}</td>
								<td>${ staff.name}</td>
								<td>${ staff.email}</td>
								<td>${ staff.address}</td>
								<td>${ staff.contact}</td>
								<td>${ staff.dob}</td>
								<td>${ staff.doj}</td>
								<td><a href="staff/delete?staffId=${staff.id}" class="action-links">Delete</a>
								       <a href="staff/edit?staffId=${staff.id}" class="action-links">Edit</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<h3 class="headings">No Staff Available at the moment......</h3>
				</c:otherwise>
			</c:choose>
		</div>
		<!-- table Container -->
		
			<a class="link" href="staff/add"><button type="submit" class="admin-control-button">Add Staff</button></a>
		
	</div>
	<!-- container -->
	<%@include file="/WEB-INF/pages/footer.html"%>
</body>
</html>









