<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<c:if test="${pageContext.request.UserPrincipal.name !=null }" >
		<h2>Welcome:${pageContext.request.UserPrincipal.name}
		    <a href="<c:url value="/j_spring_security_logout" />" >logout</a>
		</h2>
	</c:if>	
</body>
</html>