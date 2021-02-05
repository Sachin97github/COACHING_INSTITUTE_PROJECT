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
   <%@include file="/WEB-INF/pages/home-sample.jsp"%>
  <div class="container">
    <div class="form-div">
                        <h4 class="form-heading">Edit Course</h4>
  <frm:form cssClass="form" method = "POST" action = "admin/courseEdit.htm" modelAttribute="course" >
                <div class="form-row">
                        <label>Course Id</label><frm:input type="text" cssClass="form-input"  path="id" readonly="true" />
                     </div>
                      <div class="form-row">
                        <label>Course Name</label><frm:input type="text" cssClass="form-input"  path="name" required="required"/>
                     </div>
                    <div class="form-row">
                      <label>Start Date</label><frm:input type="date" cssClass="form-input"  path="startDate" required="required"/>
                   </div>
                    <div class="form-row">
                      <label>Select Faculty</label> 
                       <frm:select cssClass="form-input"  path="facultyDTO.id" required="required">
                                 <frm:option value="${facultyDTO.id }" label="${facultyDTO.name}"> </frm:option>
                           <c:forEach var="faculty"   items="${facultyList}">
                                 <frm:option value="${faculty.id} ">${faculty.name}  -  ${faculty.subject} </frm:option>
                           </c:forEach>
                       </frm:select>
                   </div>
                   <div class="form-row">
                      <label>Price</label>  <frm:input cssClass="form-input"  path="price" required="required"/>
                   </div>
                 <div class="form-row">
                  <button type="submit" class="form-submit">Edit</button>
               </div>
              </frm:form>
    </div> <!-- Container -->
   <%@include file="/WEB-INF/pages/footer.html"%>
</body>
</html>
<!-- END -->