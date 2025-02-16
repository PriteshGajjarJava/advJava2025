<%@page import="com.pga.*" %>
<%
	TableInfo tables[] = new TableInfo[5];
	tables[0] = new TableInfo(1, 4, true);
	tables[1] = new TableInfo(2, 4, false);
	tables[2] = new TableInfo(3, 6, true);
	tables[3] = new TableInfo(4, 2, false);
	tables[4] = new TableInfo(5, 6, false);
%>


<HTML>
 <head>
  
  <link rel="stylesheet" href="./bootstrap.min.css"/>
  
  <style type="text/css">
  	.table-details {
	  	margin: 50px;
	    background-color: #faf9ed;
  		height: 250px;
  		width: 250px;
  		border: 1px solid black;
  	}
  	  	.busy {
  		background-color: orangered;
  	}
  	.free {
  		background-color: lightgreen;
  	}
  	
  </style>
  
  <script type="text/javascript" src="./jquery-3.7.1.min.js"></script>
  <script type="text/javascript">
  
  	$().ready(() => {
  		$('.table-details').click((event) => {
  			$('.table-details').css('border', '1px solid black');
  			$(event.target).css('border', '5px solid black');
  		});
  	});
  </script>
 </head>
 <body>
 <form action="./order.jsp">
 	<div class="d-flex flex-row">
  <%
	 for (int i=0; i < tables.length; i++) {
  %>
  		<div class="table-details <%= (tables[i].isOccupied() ? "busy" : "free") %> id="table-<%=i+1%>">
  			<span> Table <%=i+1%> </span>
  			<div> Capacity = <%= tables[i].getCapacity() %></div>
  		</div>
  
  <%
	}
  %> 
  
  	</div>
 	
 	<center><button class="btn btn-primary">Take Order</button></center>
 </form>
 </body>
</HTML>

