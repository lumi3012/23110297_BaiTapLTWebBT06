<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Trang chủ</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }
        header {
            background: #2e7d32;
            color: white;
            padding: 15px 20px;
            text-align: center;
            font-size: 20px;
            font-weight: bold;
        }
        .container {
            display: flex;
            height: calc(100vh - 60px);
        }
        .sidebar {
            width: 220px;
            background: #f4f4f4;
            padding: 20px;
            border-right: 1px solid #ccc;
        }
        .sidebar h3 {
            margin-top: 0;
            color: #2e7d32;
        }
        .sidebar a {
            display: block;
            padding: 10px;
            color: #333;
            text-decoration: none;
            margin-bottom: 8px;
            border-radius: 5px;
            transition: 0.3s;
        }
        .sidebar a:hover {
            background: #e0e0e0;
            color: #2e7d32;
        }
        .content {
            flex: 1;
            padding: 20px;
        }
        .logout {
            color: white;
            float: right;
            font-size: 14px;
        }
    </style>
</head>
<body>
<header>
    Hệ thống Quản lý Web
    <a class="logout" href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
</header>
<div class="container">
    <div class="sidebar">
        <h3>Menu</h3>
        <a href="${pageContext.request.contextPath}/category">📂 Quản lý Category</a>
        <a href="${pageContext.request.contextPath}/video">🎬 Quản lý Video</a>

        <c:if test="${sessionScope.user.roleid == 1}">
            <a href="${pageContext.request.contextPath}/admin/users">👤 Quản lý User</a>
        </c:if>
    </div>
    <div class="content">
        <h2>Xin chào, ${sessionScope.user.fullname}!</h2>
        <p>Role của bạn: 
            <c:choose>
                <c:when test="${sessionScope.user.roleid == 1}">Admin</c:when>
                <c:when test="${sessionScope.user.roleid == 2}">Manager</c:when>
                <c:otherwise>User</c:otherwise>
            </c:choose>
        </p>
        <p>Hãy chọn chức năng ở menu bên trái để tiếp tục.</p>
    </div>
</div>
</body>
</html>
