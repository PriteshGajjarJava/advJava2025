<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<sql:setDataSource var="db"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost/college"
	user="root" password=""/>
	
<sql:query dataSource="${db}" sql="select * from login where username=? and password=?" var="rs">
	<sql:param value="${param.user}"/>
	<sql:param value="${param.pwd}"/>
</sql:query>

<c:choose>
 <c:when test="${not empty rs.rows}">
 	<jsp:forward page="./home.html"/>
 </c:when>
 <c:otherwise>
  	<jsp:forward page="./error.html"/>
 
 </c:otherwise>
</c:choose>