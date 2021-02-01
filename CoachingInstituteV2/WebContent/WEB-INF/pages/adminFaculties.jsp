
<%@ page language="java" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<%@include file="/WEB-INF/pages/home-sample.html"%>
	<div class="container">
	 <diiv class="admin-controls-container">
      <h2>Panel</h2>      
      <a class="link" href="courses.htm"><button type="submit" class="admin-control-button">Course</button><a></a>
      <a class="link" href="faculties.htm"><button type="submit" class="admin-control-button">Faculty</button></a>
      <a class="link" href="staffMembers.htm"><button type="submit" class="admin-control-button">Staff</button></a>
      <a class="link" href="students.htm"><button type="submit" class="admin-control-button">Student</button></a>
    </diiv>
	
		<h2 class="headings">Faculty Information</h2>
		<div class="table-container">
			<c:choose>
				<c:when test="${not empty facultyList || not null}">
					<table class="data">
						<tr>
						<th>Serial no</th>
							<th>faculty</th>
							<th>Name</th>
							<th>Subject</th>
							<th>Email</th>
						<th>Adress</th>
						<th>Contact</th>
						<th>Dob</th>
						<th>Doj</th>
						
							<th>State</th>
							<th>Action</th>
						</tr>
						<c:forEach var="faculty" items="${facultyList}" varStatus="counter">
							<tr>
							<td>${ counter.index+1}</td>
								<td>${ faculty.id}</td>
								<td>${ faculty.name}</td>
								<td>${ faculty.subject}</td>
								<td>${ faculty.email}</td>
								<td>${ faculty.address}</td>
								<td>${ faculty.contact}</td>
								<td>${ faculty.dob}</td>
								<td>${ faculty.doj}</td>
								<td>${ faculty.state}
								  <div> 
										<c:choose>
											<c:when test="${faculty.state == 'ACTIVE' }">
												<a href="facultyChangeState.htm?facultyId=${faculty.id}&state=NOTACTIVE"
													class="action-links">Not Active</a>
											</c:when>
											<c:when test="${faculty.state == 'NOTACTIVE' }">  
												<a href="facultyChangeState.htm?facultyId=${faculty.id}&state=ACTIVE"
													class="action-links">active</a>
											</c:when>
											<c:otherwise>
											</c:otherwise>
										</c:choose>
									</div>
								</td>
								<%-- <td><a	href="facultySoftDelete.htm?id=${faculty.id}" class="action-links">Delete</a>
								      <a	href="facultyHardDelete.htm?id=${faculty.id}" class="action-links">delete</a>
								</td> --%>
								<td><a	href="facultyEdit.htm?facultyId=${faculty.id}" class="action-links">edit</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<h2 class="headings">No Faculties Available at the
						moment......</h2>
				</c:otherwise>
			</c:choose>
		</div>
		<!-- table Container -->
		<a class="link" href="facultyAdd.htm"><button type="submit" class="admin-control-button">Add Faculty</button></a>
	</div>
	<!-- container -->
	<%@include file="/WEB-INF/pages/footer.html"%>
</body>
</html>









