<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

	

<html>

<title>index</title>

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

<body>

<h1>Spring MVC Sample</h1>



<h3>Sample</h3>

<ul>
	
	<li><a href="user">User</a></li>	
</ul>



</body>
</html>
