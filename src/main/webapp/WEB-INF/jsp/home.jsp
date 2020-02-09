<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html >
<head>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
  <meta charset="UTF-8">
  <title>Contact Management Application</title>
  <c:url value="/css/style.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
     
</head>

<body>  

<div class="pen-title">
  <h2>Contact Management Application</h2>
  
</div>
<br>
<br>
<br>
<br>

<div class="container">
  <div class="card"></div>
  <div class="card">
    
    <%-- <form action ="LoginController"  method="POST"> --%>
      <div class="input-container">
      <span style="color:red;" class="hint"></span>
      		 <h4>Disclaimer: This service is restricted application interface, accessible only to Production authorised users and adminstrators.
      		 If you are not intended user, please close the application.</h4>
  		<div class="rerun">
      <a href="all_contacts">View all Contact</a>
		<a href="show_addcontact">Add Contact</a>
		</div>
		<!-- <div class="rerun">
		<button type="button" onclick="winclose();" value="close"> 
		<input type="button" value="Close this window" onclick="self.close()">
		<span><a>Close</a></span> </button>
		  </div> -->
      </div>
   
  </div>
  
</div>

</body>
</html>