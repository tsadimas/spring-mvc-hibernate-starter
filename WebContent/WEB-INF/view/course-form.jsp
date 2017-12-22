<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add Course for ${course.teacher}</h3>
	<form:form action="${pageContext.request.contextPath}/course/saveCourse/${course.teacher.id}" modelAttribute="course" method="POST" class="ui form">
		<div class="field">
			<label>Title</label> 
			<form:input path="title"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>