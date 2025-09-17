<%@ include file="/WEB-INF/views/header.jsp" %>
<h3>Your Categories</h3>
<ul>
<c:forEach var="c" items="${categories}">
    <li>${c.name} - ${c.description}</li>
</c:forEach>
</ul>
<%@ include file="/WEB-INF/views/footer.jsp" %>
