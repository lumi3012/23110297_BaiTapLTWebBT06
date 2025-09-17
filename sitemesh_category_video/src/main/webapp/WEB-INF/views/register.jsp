<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f0f4f0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .register-box {
        background: #fff;
        padding: 30px 25px;
        border-radius: 10px;
        box-shadow: 0 6px 15px rgba(0,0,0,0.2);
        width: 400px;
        text-align: center;
    }
    .register-box h2 {
        color: #2e7d32;
        margin-bottom: 20px;
    }
    .register-box input[type="text"],
    .register-box input[type="password"],
    .register-box input[type="email"],
    .register-box input[type="tel"] {
        width: 100%;
        padding: 10px;
        margin: 8px 0;
        border: 1px solid #ccc;
        border-radius: 6px;
        outline: none;
    }
    .register-box input:focus {
        border-color: #2e7d32;
        box-shadow: 0 0 5px rgba(46,125,50,0.5);
    }
    .register-box button {
        width: 100%;
        padding: 10px;
        margin-top: 12px;
        border: none;
        background: #43a047;
        color: #fff;
        font-size: 16px;
        border-radius: 6px;
        cursor: pointer;
        transition: 0.3s;
    }
    .register-box button:hover {
        background: #2e7d32;
    }
    .register-box .alert {
        color: red;
        margin-bottom: 10px;
    }
    .register-box p {
        margin-top: 12px;
        font-size: 14px;
    }
    .register-box a {
        color: #2e7d32;
        text-decoration: none;
    }
    .register-box a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<div class="register-box">
    <h2>Đăng ký tài khoản</h2>
    <c:if test="${error != null}">
        <p class="alert">${error}</p>
    </c:if>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <input type="text" name="username" placeholder="Tên đăng nhập" required>
        <input type="text" name="fullname" placeholder="Họ và tên" required>
        <input type="password" name="password" placeholder="Mật khẩu" required>
        <input type="tel" name="phone" placeholder="Số điện thoại" required>
        <input type="email" name="email" placeholder="Email" required>
        <button type="submit">Đăng ký</button>
    </form>
    <p>Đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a></p>
</div>
</body>
</html>
