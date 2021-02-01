
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
	
		<h2 class="headings">Courses Information</h2>

		<div class="table-container">
			<c:choose>
				<c:when test="${not empty sessionScope.courseList || not null}">
					<table class="data">
						<tr>
							<th>Serial no</th>
							<th>Course Id</th>
							<th>Name</th>
							<th>Start Date</th>
							<th>Price</th>
							<th>State</th>
							<th>Faculty</th>
							<th>Action</th>
						</tr>
						<c:forEach var="course" items="${courseList}" varStatus="counter">
							<tr>
								<td>${ counter.index+1}</td>
								<td>${ course.id}</td>
								<td>${ course.name}</td>
								<td>${ course.startDate}</td>
								<td>${ course.price}</td>
								<td>${ course.state}
								<div> 
										<c:choose>
											<c:when test="${course.state == 'ACTIVE' }">
												<a href="courseChangeState.htm?courseId=${course.id}&state=UPCOMING"
													class="action-links">upcoming</a>
												<a href="courseChangeState.htm?courseId=${course.id}&state=FINISHED"
													class="action-links">finished</a>
											</c:when>
											<c:when test="${course.state == 'UPCOMING' }">
												<a href="courseChangeState.htm?courseId=${course.id}&state=ACTIVE"
													class="action-links">active</a>
												<a href="courseChangeState.htm?courseId=${course.id}&state=FINISHED"
													class="action-links">finished</a>
											</c:when>
											<c:when test="${course.state == 'FINISHED' }">
												<a href="courseChangeState.htm?courseId=${course.id}&state=ACTIVE"
													class="action-links">active</a>
												<a href="courseChangeState.htm?courseId=${course.id}&state=UPCOMING"
													class="action-links">upcoming</a>
											</c:when>
											<c:otherwise>
											</c:otherwise>
										</c:choose>
									</div>
								</td>
								<td>${ course.facultyDTO.name}</td>
								<td><a href="courseDelete.htm?courseId=${course.id}"
									class="action-links">delete</a>
									<a href="courseEdit.htm?courseId=${course.id}"
									class="action-links">edit</a>
									</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<h2 class="headings">No Courses Available at the moment......</h2>
				</c:otherwise>
			</c:choose>
		</div>
		<!-- table Container -->
		<a class="link" href="courseAdd.htm"><button type="submit" class="admin-control-button">Add Course</button></a>
	
	</div>
	<!-- container -->
	<%@include file="/WEB-INF/pages/footer.html"%>
</body>
</html>









