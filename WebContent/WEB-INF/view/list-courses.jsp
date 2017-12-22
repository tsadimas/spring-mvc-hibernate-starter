

<div class="ui segment">
	<h3>List of Courses</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Title</th>
			<th>Teacher</th>
			<th>Actions</th>
		</thead>
		<!-- loop over and print our courses -->
		<c:forEach var="tempCourse" items="${courses}">

			<tr>
				<td>${tempCourse.title}</td>
				<td>${tempCourse.teacher}</td>
				<td><button type="submit" id="${tempCourse.id}"
					name="deleteCourse"><i class="remove user icon"></i>
					 Delete</button>
					 <a class="ui button"
					href="<c:url value="/course/${tempCourse.id}"></c:url>"><i class="unhide icon"></i>
					View/Edit</a>
			</tr>
		</c:forEach>
	</table>
</div>

<script type="text/javascript">
	$("[name='deleteCourse']").click(function() {
		var urlCall = "<c:url value="/api/course/delete/"></c:url>";
		$.ajax({
			url : urlCall + $(this).attr('id'),
			type : 'DELETE',
			success : function(result) {
				console.log(result);
				$(location).attr("href", "<c:url value="/course/list"></c:url>");
			},
			error : function(result) {
				console.log(result);
			},
		});
	});
</script>