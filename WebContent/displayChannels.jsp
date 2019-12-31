<%@ page import="entities.Channel,java.util.List" language="java" contentType="text/html; charset=ISO-8859-1"
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

	<%-- Displaying Channels --%>
	<%
	    List<Channel> myChannels = (List<Channel>)request.getAttribute("channel");
		for(Channel channel: myChannels){
	%>
  <tr>
    
    <td>
     <span class="display" style="color:green">Channel Name:</span><span class="display"><%= channel.getChannelName() %></span>
     <br><br>
     <span class="display" style="color:green">Channel Band:</span> <span class="display"><%= channel.getChannelBand() %></span>
     <br><br>
     <span class="display" style="color:green">Video Frequency:</span> <span class="display"><%= channel.getVideoFrequency() %></span>
     <br><br>
     <span class="display" style="color:green">Audio Frequency:</span> <span class="display"><%= channel.getAudioFrequency() %></span>
     <br><br>
     <span class="display" style="color:green">Channel Charge Type:</span> <span class="display"><%= channel.getChannelChargeType() %></span>
     <br><br>
     <span class="display" style="color:green">Channel Transmission type:</span> <span class="display"><%= channel.getChannelTransmissionType() %></span>
     <br><br>
     <span class="display" style="color:green">Channel Charges:</span> <span class="display"><%= channel.getChannelCharge() %></span>
     <br><br>
     <span class="display" style="color:green">Channel Status:</span> <span class="display"><%= channel.getChannelEnableOrDisable() %></span>
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