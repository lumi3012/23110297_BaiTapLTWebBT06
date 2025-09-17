<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đang xử lý...</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f6fff6;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .loader {
            text-align: center;
        }
        .spinner {
            border: 6px solid #c8e6c9;
            border-top: 6px solid #2e7d32;
            border-radius: 50%;
            width: 60px;
            height: 60px;
            animation: spin 1s linear infinite;
            margin: 0 auto 20px auto;
        }
        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
        h3 {
            color: #2e7d32;
        }
    </style>
</head>
<body>
<div class="loader">
    <div class="spinner"></div>
    <h3>Vui lòng chờ, hệ thống đang xử lý...</h3>
</div>
</body>
</html>
