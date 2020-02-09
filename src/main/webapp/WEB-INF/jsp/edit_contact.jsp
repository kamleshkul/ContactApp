<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>  
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/css/style.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/tabbed-panels.css">
<title>Update Contact</title>

<script type="text/javascript">/* 
$(document).on("click", "#submit", function($){
        var sel = $("#sel").val();
        $(this).sel
        $("#sel").change(function(){
            cntr = $("#sel option:selected").val();
		$('form').submit();
        });
    }); */
    $(document).ready(function() {
        /* $('#sel').change(function(){ */
        	$("submit").click(function(){
            var rep = $('#sel').val();
            $("#sel").change(function(){
                cntr = $("#sel option:selected").val();
            }
            alert("You have selected status- " + cntr);
            cntr.submit();
        });
    });
</script>
<!-- <script>
	function submitform() {
		var x = document.getElementById('updateContact');
		x.submit();
		$("#sel").change(function({
		    var x=$(this).val();
		    x.submit();
		});
			}
	
	
</script> -->
</head>
<body>
	<div class="pen-title">
		<H2>Contact Management Application</H2>
	</div>
	<!-- <a style="float : right;" href="/logout">Logout</a> -->
	<div class="tabbed">
		<input name="tabbed" id="tabbed1" type="radio" checked>
		<section> 		<H1>
			<label for="tabbed1">Update contacts</label>
		</H1>
		<div>
			<form action="update_contact" id="updateContact" name="updateContact">


				<input type="hidden" name="contactId" id="contactId"
					value="${con.contactId}">
				<table class="centered" border="1">

					<!-- <div id="content"> -->
					First Name:
					<input type="text" name="firstName" id="firstName"
						value="${con.firstName}" />
					<br> Last Name:
					<input type="text" name="lastName" id="lastName"
						value="${con.lastName}" />
					<br> Email id:
					<input type="text" name="emailId" id="emailId"
						value="${con.emailId }" />
					<br> Phone No:
					<input type="text" name="phoneNumber" id="phoneNumber"
						value="${con.phoneNumber}" />
					<br>
					
					Status:
					<input type="text" name="status" id="status" value="${con.status}" readonly/>
				
					<br>
					<div class="rerun">
						<button id="submit" type="submit" onclick="submitform();"
							value="UpdateContact">
							<span><a>Update Contact</a></span>
						</button>
					</div>
				</table>
				<a href="home">Home</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
				&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
				&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
				&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a href="all_contacts">Back</a>
				<!-- </div> -->

			</form>
		</div>
		</section>
	</div>
</body>
</html>