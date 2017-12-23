

<div class="ui segment">
	<h3>List of Students</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Actions</th>
		</thead>
		<!-- loop over and print our students -->
		<c:forEach var="tempStudent" items="${students}">

			<tr>
				<td>${tempStudent.firstName}</td>
				<td>${tempStudent.lastName}</td>
				<td>${tempStudent.email}</td>
				<td><button type="submit" class="ui button" id="${tempStudent.id}"
					name="deleteStudent"><i class="remove user icon"></i>
					 Delete</button>
					 <a class="ui button"
					href="<c:url value="/student/${tempStudent.id}"></c:url>"><i class="unhide icon"></i>
					View/Edit</a>
					<a class="ui button" href="<c:url value="/student/assignCourse/${tempStudent.id}"></c:url>"><i
						class="add user icon"></i>Assign Course</a>
					<a class="ui button" href="<c:url value="/course/student/${tempStudent.id}/list"></c:url>"><i
						class="list icon"></i>List Courses</a>	
			</tr>
		</c:forEach>
	</table>
	
	<a class="ui button" href="${pageContext.request.contextPath}/student/showAddForm" class="item"><i	class="add circle icon"></i>Add Student</a>
</div>



<script type="text/javascript">
	$("[name='deleteStudent']").click(function() {
		var urlCall = "<c:url value="/api/student/delete/"></c:url>";
		$.ajax({
			url : urlCall + $(this).attr('id'),
			type : 'DELETE',
			success : function(result) {
				console.log(result);
				$(location).attr("href", "<c:url value="/student/list"></c:url>");
			},
			error : function(result) {
				console.log(result);
			},
		});
	});
</script>