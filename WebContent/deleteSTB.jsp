<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DeleteSTB</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
	
	<form action="MyServlet" method="get">
	<div class ="title">
<center><h1>Infinity DTH</h1></center></div><br><br>
	<table class="info">
		<tr>
		  
			<td style="color:rgba(255,0,0,0.8)">Enter the STB Type You Want to Delete: </td>
			<td><input type="text" name="Type"></td>
		</tr>
	</table>
	<br>
	<br>
	
	<input type="hidden" name="option" value="settopbox">
	<input type="hidden" name="crud" value="delete">
	<center><input class="btn" type="submit" value="Submit" ></center>
	</form>

</body>
</html>