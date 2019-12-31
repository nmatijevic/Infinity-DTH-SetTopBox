<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddChannel</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
	<form action="MyServlet" method="get">
	<div class ="title">
<center><h1>Infinity DTH</h1></center></div><br><br>
	<table class="info">
	
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Enter Channel Name : </td>
		<td><input type="text" name="channelName">  <br>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Channel Band : </td>
		<td><input type="text" name="channelBand"> <br>
	</tr> 
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Video Carrier Frequency : </td>
		<td><input type="range" name="videoFrequency" min ="40" max="225"><br>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Audio Carrier Frequency: </td>
		<td><input type="range" name="audioFrequency" min ="45" max="230" ><br>
	</tr>

	<tr>
		<td style="color:rgba(255,0,0,0.8)">Channel Charge Type : </td>
		<td><input type="radio" name="channelChargeType" value="Free To Air">Free to Air (FTA) <br>
		<input type="radio" name= "channelChargeType" value="Paid"> Paid </td>
	</tr>
	
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Channel Transmission Type : </td>
		<td><input type="radio" name="channelTransmissionType" value="Standard"> Standard <br>
		<input type="radio" name= "channelTransmissionType" value="HD">HD</td>
	</tr>
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Channel Charge : </td>
		<td>$<input type="text" name="channelCharge"></td>
	</tr>
	
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Channel Enable Status : </td>
		<td><input type="radio" name="enableOrDisable" value="Enable">Enable<br>
		<input type="radio" name= "enableOrDisable" value="Disable">Disable</td>
	</tr>
	
	<tr>
		<td style="color:rgba(255,0,0,0.8)">Category Name of the channel : </td>
		<td>$<input type="text" name="categoryName"></td>
	</tr>
	
	
	</table><br><br>
	<input type="hidden" name="option" value="package">
	<input type="hidden" name="crud" value="channelAdd">
	<center><input class="btn" type="submit" value="Submit"></center>
	</form>
</body>
</html>