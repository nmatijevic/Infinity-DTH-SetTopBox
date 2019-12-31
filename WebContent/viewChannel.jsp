<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Infinity DTH</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class ="title">
<center><h1>Infinity DTH</h1></center></div>
<section class="container">
 <h1 style="text-align:center">Click to view Channel Details</h1>
 <div class ="Center">
 <form action="MyServlet" method="get">
 <input type="hidden" name="option" value="channel">
 <input type="hidden" name="crud" value="view">
 <input type="submit" value="Click">
 </form>
 </div> 
 </section>
</body>
</html>