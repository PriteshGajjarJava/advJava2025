<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

// Scope => Page, Request, Session, Application

<HTML>
<head>
	<style type="text/css">
		.error { color: red }
	</style>
</head>
<c:set var="salary" value="19000"/>

<c:forEach begin="1" end="10" var="i">
	<h5> Row : <c:out value="${i}"/> </h5>
</c:forEach>

<c:if test="${salary > 10000}">
	<c:out value="Salary is greater than 10000"></c:out>
</c:if>

<c:choose>
	<c:when test="${salary > 25000 }">
		<c:out value="Salary is > 25k"></c:out>
	</c:when>
	<c:otherwise>
		<div class='error'> <c:out value="Salary is < 25k"></c:out> </div>
	</c:otherwise>
</c:choose>

</HTML>