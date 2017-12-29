

<div class="ui segment">
	<h3>List of Users</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Username</th>
		</thead>
		<!-- loop over and print our students -->
		<c:forEach var="tempUser" items="${users}">

			<tr>
				<td>${tempUser.username}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a class="ui button" href="${pageContext.request.contextPath}/user/showAddForm" class="item"><i	class="add circle icon"></i>Add User</a>
</div>



