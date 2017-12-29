<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add a Student</h3>

	<form:form action="saveUser" modelAttribute="user" method="POST" class="ui form">
		<div class="field">
			<label>Username</label> 
			<form:input path="username"/>
		</div>
		<div class="field">
			<label>Password</label>
			<form:input path="password"/>
		</div>
		
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>