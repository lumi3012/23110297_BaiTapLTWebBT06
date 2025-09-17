<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý User</title>
</head>
<body>
<h2>Danh sách người dùng</h2>
<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Fullname</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Role</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.id}</td>
            <td>${u.username}</td>
            <td>${u.fullname}</td>
            <td>${u.phone}</td>
            <td>${u.email}</td>
            <td>
                <c:choose>
                    <c:when test="${u.roleid == 1}">Admin</c:when>
                    <c:when test="${u.roleid == 2}">Manager</c:when>
                    <c:otherwise>User</c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/users/edit?id=${u.id}">Sửa</a> |
                <a href="${pageContext.request.contextPath}/admin/users/delete?id=${u.id}" onclick="return confirm('Xóa user này?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
