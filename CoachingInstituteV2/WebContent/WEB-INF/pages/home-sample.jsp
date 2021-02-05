 <%@ page language="java"  isELIgnored="false" %>

<h2 class="header-heading">COACHING INSTITUTE</h2>
  <div class="header">
    <nav>
      <ul>
       <li><a href="<%=request.getContextPath()%>/home">HOME</a></li>
        <li><a href="<%=request.getContextPath()%>/showActiveFaculties">FACULTY</a></li>
        <li><a href="<%=request.getContextPath()%>/showActiveCourses">COURSE</a></li>        
        <li><a href="<%=request.getContextPath()%>/student/add">STUDENT</a></li>
        <li><a href="<%=request.getContextPath()%>/admin/adminPanel">ADMIN</a></li>
         <li><a href="#footer">ABOUT</a></li>
          <li><a href="<%=request.getContextPath()%>/logout">LOG OUT</a></li>
     </ul>
    </nav>
  </div>