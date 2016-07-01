<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<html>
<head>

	<meta name="viewport" content="width=device-width,initial-scale=1">
	
 
 	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css">	
	<style type="text/css" class="init"></style>


	<script type="text/javascript" src="https:/code.jquery.com/jquery-1.12.3.min.js">	</script>
	<script type="text/javascript"  src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js">	</script>
	<script type="text/javascript"  src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js">	</script>
	
	<style type="text/css" class="init"></style>
	
	<title>Sample Page</title>

	<script type="text/javascript" class="init">
	
		$(document).ready(function() {
			$('#example').DataTable();
		} );
	</script>
	
	
</head>


<body class="wide comments example dt-example-bootstrap"> 

	<h1>     User-Sample</h1>


	<script type="text/javascript"> 
		$(':button').click(function() {
			var url = 'user/'+document.getElementById('aa').value;
	
			$('span').text(url);
			$('form').attr('action', url);
		});
	
		$('input:submit').click(function() {
			$('form input:hidden').val($(this).attr('id'));
		});
	</script>



<h3>
	 Add User
</h3>

<c:url var="addAction" value="/user/add" ></c:url>

<form:form action="${addAction}" commandName="user"  > 

<table class="table table-striped">
	<c:if test="${!empty user.name}">
	<tr class="warning">
		<td >
			<form:label path="id" class="form-control">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	
	
	<tr class="info">
		<td >
			<form:label path="studentid">
				<spring:message text="Name:"/>
			</form:label>
		</td>
			<td><form:input path="name"  class="form-control" placeholder="Roger Federer"/></td>
		 

	</tr>
	
	<tr class="success">
		<td >
			<form:label path="studentid">
				<spring:message text="Studentid"/>
			</form:label>
		</td>
		<td>
			<form:input path="studentid" class="form-control" placeholder="150753023" />
		</td>
	</tr>
	
		<tr class="warning">
		<td>
			<form:label path="date">
				<spring:message text="Date"/>
			</form:label>
		</td>
		<td>
			<form:input path="date" class="form-control" placeholder="2020/12/12 08:00:12" />
		</td> 
	</tr>
	
	<tr class="info">
		<td > 
			<form:label path="email">
				<spring:message text="Email"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" class="form-control"  placeholder="rogee@nccu.esu.tw"/>
		</td> 
	</tr>

	
	
	
</table>	

<c:if test="${!empty user.name}">
				
			<button type="submit" class="btn btn-danger btn-lg btn-block">Edit user</button>
				
			</c:if>
			<c:if test="${empty user.name}">
			<button type="submit" class="btn btn-danger btn-lg btn-block">Add user</button>
			
			</c:if>
</form:form>

<br>


<!-- User Table -->

<h3>User List</h3>
<table id="example" class="table table-striped  table-bordered" > 
<c:if test="${!empty listUser}">
<thead  >
		<tr class="info">
		<th>ID</th>
		<th>Name</th>
		<th>Studentid</th>
		<th>Email</th>
		<th>Date</th>
	

		<th >Edit</th>
		<th >Delete</th>
	</tr>	
<thead >
<tfoot>
	<tr>
		<th >ID</th>
		<th>Name</th>
		<th>Studentid</th>
		<th>Email</th>
		<th>Date</th>
	

		<th >Edit</th>
		<th >Delete</th>
	</tr>	


</tfoot>


<tbody>

	<c:forEach items="${listUser}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.studentid}</td>
			<td>${user.email}</td>
			<td>${user.date}</td>
		
			
			<td><a href="<c:url value='/user/edit/${user.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/user/delete/${user.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	
	</tbody>
	</c:if>
	</table>






</body>
</html>
