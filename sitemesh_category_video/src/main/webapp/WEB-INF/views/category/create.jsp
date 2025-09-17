<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Category</title>
</head>
<body>
<h2>Thêm Category mới</h2>
<form action="${pageContext.request.contextPath}/category/create" method="post">
    <p>Tên: <input type="text" name="name" required></p>
    <p>Mô tả: <input type="text" name="description"></p>
    <p>Loại: <input type="text" name="type"></p>
    <button type="submit">Lưu</button>
</form>
<a href="${pageContext.request.contextPath}/category">Quay lại</a>
</body>
</html>
