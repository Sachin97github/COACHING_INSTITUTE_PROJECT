<%@page isELIgnored="false"%>
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


   <%@include file="/WEB-INF/pages/home-sample.jsp" %>

  <div class="container">
     
<center>
     <h2 style="color:green"> Success </h2> <br>
     <a href="<%=request.getContextPath() %>/home">Home</a>
</center>
    </div>
   <%@include file="/WEB-INF/pages/footer.html"%>
</body>
</html>
