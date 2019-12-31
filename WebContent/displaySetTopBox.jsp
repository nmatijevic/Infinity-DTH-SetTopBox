<%@ page import="entities.SetTopBox,java.util.List" language="java" contentType="text/html; charset=ISO-8859-1"
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

	<%-- Displaying SetTopBox's --%>
	<%
	    List<SetTopBox> mySetTopBoxs = (List<SetTopBox>)request.getAttribute("settopbox");
		for(SetTopBox setTopBox: mySetTopBoxs){
	%>
  <tr>
    
    <td>
    <span class="display" style="color:green"> SetTopBox Type:</span> <span class="display"><%= setTopBox.getSTBType() %></span>
     <br><br>
     <span class="display" style="color:green">Length:</span> <span class="display"><%= setTopBox.getSTBlength() %></span>
     <br><br>
     <span class="display" style="color:green">Breadth:</span> <span class="display"><%= setTopBox.getSTBbreadth() %></span>
     <br><br>
     <span class="display" style="color:green">Width:</span> <span class="display"><%= setTopBox.getSTBwidth() %></span>
     <br><br>
    <span class="display" style="color:green"> Price:</span> <span class="display"><%= setTopBox.getPrice() %></span>
     <br><br>
     <span class="display" style="color:green">Installation Charges:</span> <span class="display"><%= setTopBox.getInstallationCharges() %></span>
     <br><br>
    <span class="display" style="color:green"> Updation Charges:</span> <span class="display"><%= setTopBox.getUpdationCharges() %></span>
     <br><br>
     <span class="display" style="color:green">Percentage Discount:</span> <span class="display"><%= setTopBox.getPercentageDiscount() %></span>
     <br><br>
     <span class="display" style="color:green">Billing Type:</span> <span class="display"><%= setTopBox.getBillingType() %></span>
     <br><br>
     <span class="display" style="color:green">Refund Amount:</span> <span class="display"><%= setTopBox.getRefundAmount() %></span>
     <br><br>
     <span class="display" style="color:green">Features:</span> <span class="display"><%= setTopBox.getSTBFeatures().toString().replace("[","").replace("]","") %></span>
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