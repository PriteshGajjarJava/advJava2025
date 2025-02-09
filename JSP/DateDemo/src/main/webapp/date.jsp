<%@page import="java.util.*"%>

<%
	Date obj = new Date();
	String date = obj.getDate() + "/" + obj.getMonth() + "/"+ obj.getYear(); 
	String time = obj.getHours() + ":" + obj.getMinutes() + ":" + obj.getSeconds();
%>

<table border="1">
<TR> <TH> Date </TH> <TH> Time </TH> </TR>

<TR> <TD> <%= date %> </TD> <TD> <%=time %> </TD> </TR>
</table>