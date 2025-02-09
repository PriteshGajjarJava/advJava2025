<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<sql:setDataSource var="db"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost/college"
	user="root" password="sdfdsf"/>
	
<sql:query dataSource="${db}" sql="select * from login where username=? and password=?" var="rs">
	<sql:param value="${request.user}"></sql:param>
	<sql:param value="${request.pwd}"></sql:param>
</sql:query>

<c:forEach items="${rs.rows}" var="row">
	VALUE<c:out value="${row.username}"/>
	<jsp:forward page="./home.html"/>
	
</c:forEach>
<jsp:forward page="./error.html"/>
