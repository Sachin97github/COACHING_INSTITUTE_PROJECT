<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<html>
<head>
    <link rel="stylesheet" href="style/formStyle.css"></link>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet"/>
  <style><%@include file="/WEB-INF/pages/style/navBar.css"%>
      <%@include file="/WEB-INF/pages/style/formStyle.css"%>
            <%@include file="/WEB-INF/pages/style/bodyStyle.css"%>
  </style>
  </head>
<body>
<div class="main-home-container">
        <h2>
            Coaching Institute
        </h2>
        <ul class="nav-ul">
          <li ><a  href="home.htm">Home</a></li>
            <li><a  href="courseAdd.htm">Course</a></li>
            <li><a href="facultyAdd.htm">Faculty</a></li>
            <li><a  href="studentAdd.htm">Student</a></li>
             <li><a class="active" href="staffAdd.htm">Staff</a></li>
             <li><a href="about.htm">about</a></li>
             </ul>
    </div> <!--Heading-navigation container-->
    
    
<div class="container">
<h2 style="text-align: center">Add Staff Member</h2>
  <frm:form cssClass="form"  modelAttribute="staff" >
<table class="form-table" style="align:center">
		<tr>
			<td><label> Name</label></td>
			<td><frm:input cssClass="form-input"  path="name" /></td>
		</tr>	
		<tr>
			<td><label>Email</label></td>
			<td><frm:input cssClass="form-input" type="email" path="email" /></td>
		</tr>
		<tr>
			<td><label>address</label></td>
			<td><frm:input cssClass="form-input"  type="text" path="address" /></td>
		</tr>
		<tr>
			<td><label>Contact</label></td>
			<td><frm:input cssClass="form-input"  path="contact" /></td>
		</tr>
		<tr>
			<td><label>DOB</label></td>
			<td><frm:input cssClass="form-input"  type="date" path="dob" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="ADD" /></td>
		</tr>
</table></frm:form>
 </div>
  </body>
  </html>
    <!-- End of body -->


