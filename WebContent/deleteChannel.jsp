<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Channel</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<script type="text/javascript">
function msgDialog(){
	if(window.confirm("Are you sure, you want to delete this data? Deleting a package will delete the channels included in it.")){
		/* Proceed to delete data from DB */
	}
}
</script>

<body>
	<form action="MyServlet" method="get" >
	<div class ="title">
<center><h1>Infinity DTH</h1></center></div><br><br>
		<table class="info">
			<tr>
				<td style="color:rgba(255,0,0,0.8)">Enter Name of channel you want to delete : </td>
				<td><input type="text" name="deleteName"></td>
				</td>
			</tr>
			
			
		</table><br><br>
		<input type="hidden" name="option" value="channel">
	    <input type="hidden" name="crud" value="delete">
		<center><input class="btn" type="submit" value="Delete"></center>
	</form>
</body>
</html>