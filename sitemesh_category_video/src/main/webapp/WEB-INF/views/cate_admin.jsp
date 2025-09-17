<%@ include file="/WEB-INF/views/header.jsp" %>
<h3>Category Management (Admin)</h3>
<a href="category/create">Create New</a>
<ul>
<c:forEach var="c" items="${categories}">
    <li>${c.name} - ${c.description}
        <a href="category/edit?id=${c.id}">Edit</a>
        <a href="category/delete?id=${c.id}">Delete</a>
    </li>
</c:forEach>
</ul>
<%@ include file="/WEB-INF/views/footer.jsp" %>
