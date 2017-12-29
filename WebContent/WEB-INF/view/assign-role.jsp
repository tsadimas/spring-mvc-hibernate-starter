<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Assign Role to ${user}</h3>
	<c:if test="${not empty roles}">

		<form method="post"
			action="${pageContext.request.contextPath}/user/assignRole/${user.username}">
			<div class="field">

				<select name="role">
					<c:forEach items="${roles}" var="role">
						<option value="${role}">${role}</option>
					</c:forEach>
				</select>
			</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			
			<div class="field">

				<input type="submit" value="Add" />
			</div>
		</form>
	</c:if>
	<c:if test="${empty courses}">
		<h3>There are no Roles</h3>
	</c:if>
</div>