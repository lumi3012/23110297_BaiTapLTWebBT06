<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xóa Category</title>
</head>
<body>
<h2>Bạn có chắc muốn xóa category "${category.name}"?</h2>
<form method="post" action="${pageContext.request.contextPath}/category/delete">
    <input type="hidden" name="id" value="${category.id}">
    <button type="submit">Xóa</button>
    <a href="${pageContext.request.contextPath}/category">Hủy</a>
</form>
</body>
</html>
