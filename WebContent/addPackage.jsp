<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddPackage </title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
	<form action="MyServlet" method="get">
	<div class ="title">
<center><h1>Infinity DTH</h1></center></div><br><br>
	<table class="info">
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Enter Package Name : </td>
		<td><input type="text" name="packageName" >  <br>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Select Package Category</td>
		<td>
		<input type="checkbox" name="packageCategory" value="Kids">Kids<br>
		<input type="checkbox" name="packageCategory" value="Regional">Regional<br>
		<input type="checkbox" name="packageCategory" value="Informative">Informative<br>
		<input type="checkbox" name="packageCategory" value="Music">Music<br>
		<input type="checkbox" name="packageCategory" value="Movies">Movies<br>
		</td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Select Package Charge Type : </td>
		<td><input type="radio" name="packageChargeType" value="Paid by default">Paid by default<br>
		<input type="radio" name="packageChargeType" value="FTA">FTA </td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Select Package Transmission Type : </td>
		<td><input type="radio" name="packageTransmissionType" value="HD">HD <br>
		<input type ="radio" name = "packageTransmissionType" value="Standard">Standard </td>
	</tr>

	<tr>
		<td style="color:rgba(255,0,0,0.8)">Enter the cost of package : </td>
		<td>$<input type="text" name="packagePrice"></td>
	</tr>
	
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Package Available from date : </td>
		<td><input type="date" name="packageFromDate"><br>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Package Available to date  : </td>
		<td><input type="date" name="packageToDate"></td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Added by default  : </td>
		<td><input type="radio" name="packageByDefault" value="Yes">Yes<br>
		<input type ="radio" name= "packageByDefault" value="No">No</td>
	</tr>
	
	</table>
	<br>
	<br>
	<input type="hidden" name="option" value="package">
	<input type="hidden" name="crud" value="add">
	<center><input class="btn" type="submit" value="Submit"></center>
	</form>
</body>
</html>