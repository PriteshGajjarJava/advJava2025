<%@ page import="java.sql.*" %>

<%
	String user = request.getParameter("user");
	String pwd = request.getParameter("pwd");
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "");
	
	PreparedStatement ps = con.prepareStatement("select * from login where username=? and password=?");
	ps.setString(1, user);
	ps.setString(2, pwd);
	ResultSet rs = ps.executeQuery();
	
	if (rs.next()) {
		// success
		response.sendRedirect("./home11.html");
	} else {
		//failure
 		pageContext.forward("./error.html");
	}
%>