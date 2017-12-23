<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Assign Course to ${student}</h3>
	<c:if test="${not empty courses}">

		<form method="post"
			action="${pageContext.request.contextPath}/student/assignCourse/${student.id}">
			<div class="field">

				<select name="courseId">
					<c:forEach items="${courses}" var="acourse">
						<option value="${acourse.id}">${acourse.title}</option>
					</c:forEach>
				</select>
			</div>
			<div class="field">

				<input type="submit" value="Add" />
			</div>
		</form>
	</c:if>
	<c:if test="${empty courses}">
		<h3>There are no other Courses</h3>
	</c:if>
</div>