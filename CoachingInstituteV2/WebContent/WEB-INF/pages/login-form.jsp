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
                        <h4 class="form-heading">Login</h4>
               <form  action="<%= request.getContextPath()%>/login" method="post" >
                      <div class="form-row">
                        <label>Username</label><input type="text" class="form-input"  name="username" required="required"/>
                     </div>
                    <div class="form-row">
                      <label>Password</label><input type="password" class="form-input" name="password" required="required" />
                   </div>
                 <div class="form-row">
                  <button type="submit" class="form-submit">Login</button>
               </div>
              </form>
    </div> <!-- Container -->
   <%@include file="/WEB-INF/pages/footer.html"%>
</body>
</html>
<!-- END -->