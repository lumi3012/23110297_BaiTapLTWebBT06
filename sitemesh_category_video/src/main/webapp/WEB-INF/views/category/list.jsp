<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Category</title>
</head>
<body>
<h2>Danh sách Category</h2>
<a href="${pageContext.request.contextPath}/category/create">+ Thêm mới</a>
<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Mô tả</th>
        <th>Loại</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="c" items="${categories}">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.description}</td>
            <td>${c.type}</td>
<%--             <td><c:choose> --%>
<%-- <%--                 <c:when test="${c.active}">Active</c:when> --%> --%>
<%--                 <c:otherwise>Inactive</c:otherwise> --%>
<%--             </c:choose></td> --%>
            <td>
                <a href="${pageContext.request.contextPath}/category/edit?id=${c.id}">Sửa</a> |
                <a href="${pageContext.request.contextPath}/category/delete?id=${c.id}" onclick="return confirm('Xóa category này?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
