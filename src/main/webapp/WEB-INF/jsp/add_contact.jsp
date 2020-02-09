<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<c:url value="/css/style.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/tabbed-panels.css">

<title>Add Contact</title>
<style>
.body {
	width: 100%;
}

labell {
	display: flex;
	flex-direction: row;
	justify-content: flex-end;
	text-align: right;
	width: 400px;
	line-height: 26px;
	margin-bottom: 10px;
}

input {
	height: 20px;
	flex: 0 0 200px;
	margin-left: 10px;
}
</style>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>


</head>
<body>
	<div class="pen-title">
		<H2>Contact Management Application</H2>
	</div>

	<div class="tabbed">
		<input name="tabbed" id="tabbed1" type="radio" checked>
		<section>
		<H1>
			<label for="tabbed1">Add contacts</label>
		</H1>

		<div>
			<form:form action="process_addcontact" id="contactform" method="post">

				<p class="error">${error}</p>
				<div id="content">
					<labell>
					<span>First Name: *</span>
					<input type="text" name="firstName" id="firstName" path="firstName"
						required="required" /></labell>
					<labell>
					<span>Last Name: *</span>
					<input type="text" name="lastName" id="lastName" path="lastName"
						required="required" /></labell>
					<labell>
					<span>Email id: *</span> <input type="text" name="emailId"
						id="emailId" path="emailId" required="required" /></labell>
					<labell>
					<span>` Number: *</span>
					<input type="text" name="phoneNumber" id="phoneNumber"
						path="phoneNumber" required="required" class="phone_val" /></labell>
					<td><form:errors path="firstName" cssClass="error" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
					<td><form:errors path="emailId" cssClass="error" /></td>
					<td><form:errors path="phoneNumber" cssClass="error" /></td> <span>&nbsp;
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Status: *</span>&nbsp; &nbsp;
					&nbsp; <select name="status">
						<option value="Active">Active</option>
						<option value="Inactive">Inactive</option>
					</select>

					<labell></labell>
					<br>

					<div class="rerun">
						<button type="submit" value="AddContact" class="submit">
							<span><a>Add Contact</a></span>
						</button>
						<button type="RESET" class="btn btn-success">
							<span><a>Reset</a></span>
						</button>
						<button type="button">
							<a href="all_contacts">View all Contact</a>
						</button>
					</div>
					<a href="home">Home</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp;<a href="all_contacts">Back</a>
					<!-- </div> -->
				</div>

			</form:form>
			<div th:if="${errorMessage}" th:utext="${errorMessage}" class="error" />
		</div>
		</section>
	</div>
</body>
</html>