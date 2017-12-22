<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Assign Course to ${teacher}</h3>


	<form method="post"
		action="${pageContext.request.contextPath}/teacher/assignCourse/${teacher.id}">
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

</div>