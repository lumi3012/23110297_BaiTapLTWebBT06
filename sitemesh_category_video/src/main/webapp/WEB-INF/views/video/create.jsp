<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Video</title>
</head>
<body>
<h2>Danh sách Video</h2>

<form action="${pageContext.request.contextPath}/video/search" method="get">
    <input type="text" name="keyword" placeholder="Tìm kiếm video...">
    <button type="submit">Tìm</button>
</form>

<a href="${pageContext.request.contextPath}/video/create">+ Thêm Video mới</a>

<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Mô tả</th>
        <th>Thể loại</th>
        <th>Danh mục</th>
        <th>Video</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="v" items="${videos}">
        <tr>
            <td>${v.id}</td>
            <td>${v.title}</td>
            <td>${v.description}</td>
            <td>${v.genre}</td>
            <td>${v.category.name}</td>
            <td>
                <video width="200" controls>
                    <source src="${pageContext.request.contextPath}${v.path}" type="video/mp4">
                    Trình duyệt không hỗ trợ video.
                </video>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/video/edit?id=${v.id}">Sửa</a> |
                <a href="${pageContext.request.contextPath}/video/delete?id=${v.id}" onclick="return confirm('Xóa video này?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
