<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sửa Category</title>
</head>
<body>
<h2>Sửa Category</h2>
<form action="${pageContext.request.contextPath}/category/edit" method="post">
    <input type="hidden" name="id" value="${category.id}">
    <p>Tên: <input type="text" name="name" value="${category.name}" required></p>
    <p>Mô tả: <input type="text" name="description" value="${category.description}"></p>
    <p>Loại: <input type="text" name="type" value="${category.type}"></p>
    <p>Active: <input type="checkbox" name="active" <c:if test="${category.active}">checked</c:if>></p>
    <button type="submit">Cập nhật</button>
</form>
<a href="${pageContext.request.contextPath}/category">Quay lại</a>
</body>
</html>
