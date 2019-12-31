<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateSTB</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
	<form action="MyServlet" method="get">
		<div class ="title">
<center><h1>Infinity DTH</h1></center></div>
	<table class="info">
	
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Enter the STB Type You Want to Change : </td>
		<td><input type="text" name="oldType"></td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Select New STB Type : </td>
		<td><input type="radio" name="newType" value="Standard STB">Standard STB<br>
		<input type="radio" name="newType" value="High Definition STB">High Definition STB<br>
		<input type="radio" name="newType" value="High Definition Recorder STB">High Definition Recorder STB<br>
		<input type="radio" name="newType" value="IPTV">IPTV</td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Enter STB Length : </td>
		<td><input type="text" name="stbLength"></td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Enter STB Breadth : </td>
		<td><input type="text" name="stbBreadth"></td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Enter STB Width : </td>
		<td><input type="text" name="stbWidth"></td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Select features of this STB : </td>
		<td><input type="checkbox" name="feature" value="Multi Lingual">Multi-Lingual<br>
		<input type="checkbox" name="feature" value="Genre Wise Channel Guide">Genre Wise Channel Guide<br>
		<input type="checkbox" name="feature" value="Live Recording">Live Recording<br>
		<input type="checkbox" name="feature" value="Scheduled Recording">Scheduled Recording<br>
		<input type="checkbox" name="feature" value="Pause/Play">Pause/Play<br>
		<input type="checkbox" name="feature" value="Rewind/Forward">Rewind/Forward<br>
		<input type="checkbox" name="feature" value="Slow Motion">Slow Motion<br>
		<input type="checkbox" name="feature" value="Child Lock">Child Lock<br>
		<input type="checkbox" name="feature" value="Preview Screen">Preview Screen<br>
		<input type="checkbox" name="feature" value="Program Reminder">Program Reminder</td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Enter the cost of selected STB Type : </td>
		<td>$<input type="text" name="stbPrice"></td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Enter Installation Charges : </td>
		<td>$<input type="text" name="installCharges"></td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Enter Updation Charges : </td>
		<td>$<input type="text" name="updateCharges"></td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Enter Percentage Discount : </td>
		<td><input type="text" name="percentageDicount">%</td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Select Billing Type Availability : </td>
		<td><input type="checkbox" name="billingType" value="Pre-Paid">Pre-Paid<br>
		<input type="checkbox" name="billingType" value="Post-Paid">Post-paid</td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Enter Refundable Deposit Amount (if post-paid) : </td>
		<td>$<input type="text" name="refundAmount"></td>
	</tr>
	</table><br><br>
	<input type="hidden" name="option" value="settopbox">
	<input type="hidden" name="crud" value="update">
	<center><input class='btn' type="submit" value="Submit" ></center>
	</form>
</body>
</html>