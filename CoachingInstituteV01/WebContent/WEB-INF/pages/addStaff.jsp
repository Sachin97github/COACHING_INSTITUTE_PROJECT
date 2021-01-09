
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h2 style="text-align: center">Add Staff</h2>
	<frm:form modelAttribute="faculty" >
<table  align="center" >
	<!-- First time get and Than Post -->
		<tr>
			<td>Id</td>
			<td><frm:input path="id" /></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><frm:input path="name" /></td>
		</tr>	
		<tr>
			<td>Email</td>
			<td><frm:input type="email" path="email" /></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><frm:input path="address" /></td>
		</tr>
		<tr>
			<td>DOB</td>
			<td><frm:input type="date" path="dob" /></td>
		</tr>
		<tr>
			<td></td>
			<td><frm:input path="contact" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="ADD" /></td>
		</tr>
	
</table></frm:form>


