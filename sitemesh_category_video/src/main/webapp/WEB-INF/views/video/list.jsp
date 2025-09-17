<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sửa Video</title>
</head>
<body>
<h2>Sửa Video</h2>
<form action="${pageContext.request.contextPath}/video/edit" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${video.id}">
    <p>Tiêu đề: <input type="text" name="title" value="${video.title}" required></p>
    <p>Mô tả: <input type="text" name="description" value="${video.description}"></p>
    <p>Thể loại: <input type="text" name="genre" value="${video.genre}"></p>
    <p>Danh mục:
        <select name="categoryId" required>
            <c:forEach var="c" items="${categories}">
                <option value="${c.id}" <c:if test="${video.category.id == c.id}">selected</c:if>>
                    ${c.name}
                </option>
            </c:forEach>
        </select>
    </p>
    <p>Video hiện tại:</p>
    <video width="250" controls>
        <source src="${pageContext.request.contextPath}${video.path}" type="video/mp4">
        Trình duyệt không hỗ trợ video.
    </video>
    <p>Tải lên file mới (nếu muốn thay đổi): <input type="file" name="file" accept="video/mp4"></p>
    <button type="submit">Cập nhật</button>
</form>
<a href="${pageContext.request.contextPath}/video">Quay lại</a>
</body>
</html>
