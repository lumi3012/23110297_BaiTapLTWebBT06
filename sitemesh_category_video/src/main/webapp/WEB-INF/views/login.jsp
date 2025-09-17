<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f0f4f0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .login-box {
        background: #fff;
        padding: 30px 25px;
        border-radius: 10px;
        box-shadow: 0 6px 15px rgba(0,0,0,0.2);
        width: 360px;
        text-align: center;
    }
    .login-box h2 {
        color: #2e7d32;
        margin-bottom: 20px;
    }
    .login-box input[type="text"],
    .login-box input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 8px 0;
        border: 1px solid #ccc;
        border-radius: 6px;
        outline: none;
    }
    .login-box input:focus {
        border-color: #2e7d32;
        box-shadow: 0 0 5px rgba(46,125,50,0.5);
    }
    .login-box button {
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
    .login-box button:hover {
        background: #2e7d32;
    }
    .login-box .alert {
        color: red;
        margin-bottom: 10px;
    }
    .login-box p {
        margin-top: 12px;
        font-size: 14px;
    }
    .login-box a {
        color: #2e7d32;
        text-decoration: none;
    }
    .login-box a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<div class="login-box">
    <h2>Đăng nhập</h2>
    <c:if test="${error != null}">
        <p class="alert">${error}</p>
    </c:if>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="text" name="username" placeholder="Tên đăng nhập" required>
        <input type="password" name="password" placeholder="Mật khẩu" required>
        <div style="text-align:left; margin-top:5px;">
            <label><input type="checkbox" name="remember"> Ghi nhớ đăng nhập</label>
        </div>
        <button type="submit">Đăng nhập</button>
    </form>
    <p>Bạn chưa có tài khoản? <a href="${pageContext.request.contextPath}/register">Đăng ký</a></p>
    <p><a href="${pageContext.request.contextPath}/forgot">Quên mật khẩu?</a></p>
</div>
</body>
</html>