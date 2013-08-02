<%@ include file="../common/include_tags.jsp" %>

<html>
	
	<body>
	   <form:form modelAttribute="UserForm"  action="/lms-app/showAddUser" method="get">
			<p> <a  href="showAddUser"> Add User </a> </p>
		</form:form>
		<form:form modelAttribute="UserForm"  action="/lms-app/showDeleteUser" method="get">
			<p> <a  href="showDeleteUser"> Delete User </a> </p>
		</form:form>
		<form:form modelAttribute="UserForm"  action="/lms-app/showDeleteUser" method="get">
			<p> <a  href="showModifyUser"> Modify User </a> </p>
		</form:form>
	</body>
</html>