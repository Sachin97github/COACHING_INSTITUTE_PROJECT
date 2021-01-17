<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
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
  </style>
  </head>
<body>
<div class="main-home-container">
        <h2 class="headings">
            Coaching Institute
        </h2>
        <ul class="nav-ul">
          <li ><a  href="home.htm">Home</a></li>
            <li><a class="active" href="courseAdd.htm">Course</a></li>
            <li><a href="facultyAdd.htm">Faculty</a></li>
            <li><a href="studentAdd.htm">Student</a></li>
            <li><a href="about.htm">about</a></li>
          </ul>
  </div> <!--Heading-navigation container-->


<div class="container">
<h2 class="headings">Add Course</h2>
	<frm:form cssClass="form"  modelAttribute="course" >
<table class="form-table"  >
	<!-- First time get and Than Post -->
		<tr>
			<td><label>Course Name</label></td>
			<td><frm:input  path="name" /></td>
		</tr>	
		<tr>
			<td><label>Start Date</label></td>
			<td><frm:input type="date" path="startDate" /></td>
		</tr>
		<tr>
			<td><label>Price</label></td>
			<td><frm:input path="price" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="ADD" /></td>
		</tr>
</table></frm:form>
</div>
</body>
</html>

