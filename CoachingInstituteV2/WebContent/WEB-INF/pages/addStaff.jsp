<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<html>
<head>
   <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
     <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet"> 
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300&display=swap" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css2?family=Fredoka+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap" rel="stylesheet"> 
    <link rel="preconnect" href="https://fonts.gstatic.com">
<style>   <%@include file="/WEB-INF/pages/style/homeStyle.css"%>
            <%@include file="/WEB-INF/pages/style/container.css"%>
        <%@include file="/WEB-INF/pages/style/dataTable.css"%>
       <%@include file="/WEB-INF/pages/style/footerStyle.css"%>
       <%@include file="/WEB-INF/pages/style/form.css"%>
  </style>
  </head>
<body>
   
   <%@include file="/WEB-INF/pages/home-sample.jsp"%>
<div class="container">
    <div class="form-div">   
                        <h4 class="form-heading">Add Staff Member</h4>
  <frm:form cssClass="form"  modelAttribute="staff" >
   <div class="form-row">
                        <label>Name</label><frm:input type="text" cssClass="form-input"  path="name" required="required"/>
                     </div>
                     <div class="form-row">
                      <label>Email</label><frm:input type="email" cssClass="form-input"  path="email" required="required"/>
                   </div> 
                   <div class="form-row">
                      <label>Address</label><frm:input type="text" cssClass="form-input"  path="address" required="required"/>
                   </div>
                    <div class="form-row">
                      <label>Contact</label><frm:input type="text" cssClass="form-input"  path="contact" required="required"/>
                   </div>
                   <div class="form-row">
                      <label>Dob</label>  <frm:input cssClass="form-input"  type="date" path="dob" required="required" />
                   </div>
                 <div class="form-row">
                  <button type="submit" class="form-submit">Add</button>
               </div>
              </frm:form>
              </div>
  <!--  -->
 </div>
  </body>
  </html>
    <!-- End of body -->


