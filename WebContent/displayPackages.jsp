<%@ page import="entities.ChannelPackage,java.util.List,java.sql.Date" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Infinity DTH</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
<table>

	<%-- Displaying Packages --%>
	<%
	    List<ChannelPackage> myPackages = (List<ChannelPackage>)request.getAttribute("package");
		for(ChannelPackage myPackage: myPackages){
	%>
  <tr>
    
    <td>
     <span class="display" style="color:green">Package name:</span> <span class="display"><%= myPackage.getPkgName() %></span>
     <br><br>
     <span class="display" style="color:green">Package Charge Type:</span> <span class="display"><%= myPackage.getPkgChargeType() %></span>
     <br><br>
     <span class="display" style="color:green">Package Category :</span> <span class="display"><%= myPackage.getPkgCategory().toString().replace("[","").replace("]","") %></span>
     <br><br>
     <span class="display" style="color:green">Package Transmission Type:</span> <span class="display"><%= myPackage.getPkgTransmissionType() %></span>
     <br><br>
     <span class="display" style="color:green">Package Cost:</span> <span class="display"><%= myPackage.getPkgCost() %></span>
     <br><br>
     <span class="display" style="color:green">Package From Date:</span> <span class="display"><%= myPackage.getPkgFromDate() %></span>
     <br><br>
     <span class="display" style="color:green">Package To Date:</span> <span class="display"><%= myPackage.getPkgToDate() %></span>
     <br><br>
     <span class="display" style="color:green">Package Default Status:</span> <span class="display"><%= myPackage.getPkgByDefault() %></span>
     <br><br>
    </td>
    
  </tr>
  <tr>
     <td>&nbsp;</td>
  </tr>
  <%
		}  
  %>
</table>
</body>
</html>