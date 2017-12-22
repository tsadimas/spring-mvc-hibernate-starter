

<div class="ui segment">
	<h3>List of Teachers</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Actions</th>
		</thead>
		<!-- loop over and print our teachers -->
		<c:forEach var="tempTeacher" items="${teachers}">

			<tr>
				<td>${tempTeacher.firstName}</td>
				<td>${tempTeacher.lastName}</td>
				<td>${tempTeacher.email}</td>
				<td><button type="submit" id="${tempTeacher.id}"
						name="deleteTeacher">
						<i class="remove user icon"></i> Delete
					</button> 
					<a class="ui button" href="<c:url value="/teacher/${tempTeacher.id}"></c:url>"><i
						class="unhide icon"></i> View/Edit</a>
					<a class="ui button" href="<c:url value="/course/showAddForm/${tempTeacher.id}"></c:url>"><i
						class="unhide icon"></i>Create Course</a>
					<a class="ui button" href="<c:url value="/teacher/assignCourse/${tempTeacher.id}"></c:url>"><i
						class="unhide icon"></i>Assign Course</a>
			</tr>
		</c:forEach>
	</table>
	
		<a class="ui button" href="${pageContext.request.contextPath}/teacher/showAddForm" class="item">Add Teacher</a>
</div>

<script type="text/javascript">
	$("[name='deleteTeacher']").click(
			function() {
				var urlCall = "<c:url value="/api/teacher/delete/"></c:url>";
				$.ajax({
					url : urlCall + $(this).attr('id'),
					type : 'DELETE',
					success : function(result) {
						console.log(result);
						$(location).attr("href",
								"<c:url value="/teacher/list"></c:url>");
					},
					error : function(result) {
						console.log(result);
					},
				});
			});
</script>