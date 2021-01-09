
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h2 style="text-align: center">Add Faculty</h2>
	<frm:form modelAttribute="course" >
<table  align="center" >
	<!-- First time get and Than Post -->
		<tr>
			<td>Course Name</td>
			<td><frm:input path="name" /></td>
		</tr>	
		<tr>
			<td>Start Date</td>
			<td><frm:input type="date" path="startDate" /></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><frm:input path="price" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="ADD" /></td>
		</tr>
</table></frm:form>


