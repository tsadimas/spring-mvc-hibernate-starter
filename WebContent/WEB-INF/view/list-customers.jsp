

		<div class="ui segment">
			<h3>List of Customers</h3>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<thead>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</thead>
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">

					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
