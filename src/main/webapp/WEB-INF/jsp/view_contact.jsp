<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<meta charset="UTF-8">

<c:url value="/css/style.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/tabbed-panels.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List/View Contacts</title>
<script>
	function selectRow(x) {
		// alert("Row index is: " + x.rowIndex);
		var con = x.getElementsByTagName('input')[0];
		console.log("Value of hidden :" + con.getAttribute('value'));

		var con_id = document.getElementById('contactId');
		con_id.setAttribute('value', con.getAttribute('value'));
		console.log(con_id.getAttribute('value'));
		//  document.getElementById("edit_contact").submit();
	}

	function submitAction(button) {
		var txt = button.innerHTML;
		var form = document.getElementById("contactform");
		if (txt.indexOf("Update") > -1) {
			form.setAttribute('action', 'show_contact');
			form.submit();
		} else if (txt.indexOf("Delete") > -1) {
			form.setAttribute('action', 'delete_contact');
			form.submit();
		} else if (txt.indexOf("Inactivate") > -1) {
			form.setAttribute('action', 'inactivate_contact');
			form.submit();
		} else if (txt.indexOf("Activate") > -1) {
			form.setAttribute('action', 'activate_contact');
			form.submit();
		} else {
			console.log("Not Valid input");
		}
		console.log(txt);

	}
</script>
<!-- <script>
	$(document).ready(function() {
		$("input[type='button']").click(function() {
			var radioValue = $("input[name='radios']:checked").val();
			if (radioValue) {
				var con_id = document.getElementById('contactId');
				con_id.setAttribute('value', con.getAttribute('value'));
				console.log(con_id.getAttribute('value'));
			}
		});
	});
</script> -->
</head>
<body>
	<div class="pen-title">
		<H2>Contact Management Application</H2>
	</div>


	<div class="tabbed">
		<input name="tabbed" id="tabbed1" type="radio" checked>
		<section>
		<H1>
			<label for="tabbed1">List/View of contacts</label>
		</H1>
		<div>

			<form id="contactform" method="post">
				<input type="hidden" name="contactId" id="contactId" value="">
			</form>
			
			<p class="error">${error}</p>
			<!-- <div id="content"> -->
			<table class="centered" border="1">
				<tr>
					<th>Select</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Phone Number</th>
					<th>Status</th>
				</tr>

				<c:forEach items="${clist}" var="con">

					<tr onclick="selectRow(this)">
						<input type="hidden" name="id" value=${con.key } />

						<td><INPUT TYPE="radio" NAME="radios" VALUE="radio1"></td>
						<td>${con.value.firstName}</td>
						<td>${con.value.lastName}</td>
						<td>${con.value.emailId}</td>
						<td>${con.value.phoneNumber}</td>
						<td>${con.value.status}</td>
					</tr>
				</c:forEach>
			</table>
			<br> <br> <br> <br>
			<div class="rerun">
				<button type="button" onclick="submitAction(this)" value="update">
					<span><a>Update</a></span>
				</button>
				<button type="button" onclick="submitAction(this)" value="delete">
					<span><a>Delete</a></span>
				</button>
				<button type="button" onclick="submitAction(this)"
					value="inactivate">
					<span><a>Inactivate</a></span>
				</button>
				<button type="button" onclick="submitAction(this)" value="activate">
					<span><a>Activate</a></span>
				</button>
				<button type="button">
					<a href="show_addcontact">Add Contact</a>
				</button>
			</div>
			<a href="home">Home</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a
				href="home">Back</a>
			<!-- </div> -->
		</div>
		</section>
	</div>
</body>
</html>