<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sửa User</title>
</head>
<body>
<h2>Sửa thông tin User</h2>
<form action="${pageContext.request.contextPath}/admin/users/edit" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <p>Username: <input type="text" value="${user.username}" readonly></p>
    <p>Fullname: <input type="text" name="fullname" value="${user.fullname}"></p>
    <p>Phone: <input type="text" name="phone" value="${user.phone}"></p>
    <p>Email: <input type="text" name="email" value="${user.email}"></p>
    <p>Role:
        <select name="roleid">
            <option value="1" <c:if test="${user.roleid == 1}">selected</c:if>>Admin</option>
            <option value="2" <c:if test="${user.roleid == 2}">selected</c:if>>Manager</option>
            <option value="3" <c:if test="${user.roleid == 3}">selected</c:if>>User</option>
        </select>
    </p>
    <button type="submit">Cập nhật</button>
</form>
<a href="${pageContext.request.contextPath}/admin/users">Quay lại</a>
</body>
</html>
