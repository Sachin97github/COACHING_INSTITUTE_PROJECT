  <%@ page language="java"  isELIgnored="false" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
<style>
      <%@include file="/WEB-INF/pages/style/homeStyle.css"%>
            <%@include file="/WEB-INF/pages/style/container.css"%>
        <%@include file="/WEB-INF/pages/style/dataTable.css"%>
       <%@include file="/WEB-INF/pages/style/footerStyle.css"%>
       <%@include file="/WEB-INF/pages/style/form.css"%>
    </style>
  </head>

<body>
   <%@include file="/WEB-INF/pages/home-sample.html"%>
   
  <div class="container">
    <div class="form-div">   
                        <h4 class="form-heading">Edit Student</h4>
 <frm:form cssClass="form"  modelAttribute="student" >
 <div class="form-row">
                        <label>id</label><frm:input type="text" cssClass="form-input"  path="id" readOnly="true"/>
                     </div>
                      <div class="form-row">
                        <label>Name</label><frm:input type="text" cssClass="form-input"  path="name"  required="required"/>
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
                      <label>Dob</label>  <frm:input cssClass="form-input"  type="date" path="dob" required="required"/>
                   </div>
                   <div class="form-row">
                      <label>DoJ</label>  <frm:input cssClass="form-input"  type="date" path="doj"  readOnly="true"/>
                   </div>
                 <div class="form-row">
                  <button type="submit" class="form-submit">Done</button>
               </div>
              </frm:form>
              </div>
    </div> <!-- Container -->
   <%@include file="/WEB-INF/pages/footer.html"%>
</body>
</html>
