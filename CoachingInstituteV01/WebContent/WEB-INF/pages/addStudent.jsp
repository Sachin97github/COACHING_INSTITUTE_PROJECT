<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
  
  Add Student
  <frm:form modelAttribute="std">
    Name <frm:input path="name"/> <br>
    Address <frm:input path="address"/>
    Email <frm:input path="email"/>
    Date of birth <frm:input  type="date" path="dob"/>
    <input type="submit" value="Add">
  </frm:form>