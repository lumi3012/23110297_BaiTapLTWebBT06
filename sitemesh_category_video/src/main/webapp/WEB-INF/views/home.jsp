<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f0f4f0;
        margin: 0;
        padding: 0;
    }
    header, footer {
        background: #2e7d32;
        color: #fff;
        text-align: center;
        padding: 12px 0;
    }
    .container {
        padding: 30px;
        text-align: center;
    }
    a.btn {
        display: inline-block;
        padding: 12px 20px;
        margin-top: 15px;
        background: #43a047;
        color: #fff;
        text-decoration: none;
        border-radius: 6px;
        transition: 0.3s;
    }
    a.btn:hover {
        background: #2e7d32;
    }
</style>
</head>
<body>
<header>
    <h2>Chào mừng, <c:out value="${sessionScope.user.fullname}"/></h2>
</header>

<div class="container">
    <h3>Đây là trang Home</h3>
    <p>Bạn có thể truy cập danh mục sản phẩm tại đây:</p>
    <a href="${pageContext.request.contextPath}/category" class="btn">Quản lý Category</a>
</div>

<footer>
    <p>&copy; 2025 My Website</p>
</footer>
</body>
</html>
