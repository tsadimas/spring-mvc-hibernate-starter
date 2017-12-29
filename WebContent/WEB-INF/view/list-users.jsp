

<div class="ui segment">
	<h3>List of Users</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Username</th>
			<th>Actions</th>
		</thead>
		<!-- loop over and print our students -->
		<c:forEach var="tempUser" items="${users}">

			<tr>
				<td>${tempUser.username}</td>
				<td><a class="ui button" href="<c:url value="/user/assignRole/${tempUser.username}"></c:url>"><i
						class="add user icon"></i>Add Role</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<a class="ui button" href="${pageContext.request.contextPath}/user/showAddForm" class="item"><i	class="add circle icon"></i>Add User</a>
</div>



