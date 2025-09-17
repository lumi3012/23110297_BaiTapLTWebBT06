<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>My WebApp</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body style="font-family:sans-serif; background:#f6fff6;">
<header style="background:#2e7d32; color:white; padding:10px;">
    <h2>🌱 My WebApp</h2>
    <nav>
        <a href="${pageContext.request.contextPath}/home" style="color:white; margin-right:10px;">Home</a>
        <a href="${pageContext.request.contextPath}/category" style="color:white; margin-right:10px;">Categories</a>
        <a href="${pageContext.request.contextPath}/logout" style="color:white;">Logout</a>
    </nav>
</header>
<main style="padding:20px;">
