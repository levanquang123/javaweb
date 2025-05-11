<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm kiếm thông tin cơ bản</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 1000px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        h1 {
            color: #333;
        }
        .search-form {
            margin-bottom: 30px;
            display: flex;
            align-items: center;
        }
        .search-form input[type="text"] {
            padding: 8px;
            width: 300px;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-right: 10px;
        }
        .search-form button {
            padding: 8px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .search-form button:hover {
            background-color: #45a049;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .no-result {
            margin-top: 20px;
            color: #777;
            font-style: italic;
        }
        .back-link {
            display: block;
            margin-top: 20px;
            text-decoration: none;
            color: #333;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Tìm kiếm thông tin cơ bản</h1>

    <form action="<c:url value='/timkiem/coban' />" method="post" class="search-form">
        <input type="text" name="keyword" placeholder="Nhập từ khóa tìm kiếm..." value="${keyword}" />
        <button type="submit">Tìm kiếm</button>
    </form>

    <c:choose>
        <c:when test="${not empty sinhViens}">
            <table>
                <thead>
                <tr>
                    <th>Số CMND</th>
                    <th>Họ tên</th>
                    <th>Email</th>
                    <th>Số điện thoại</th>
                    <th>Địa chỉ</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sinhViens}" var="sv">
                    <tr>
                        <td>${sv.soCMND}</td>
                        <td>${sv.hoTen}</td>
                        <td>${sv.email}</td>
                        <td>${sv.soDT}</td>
                        <td>${sv.diaChi}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p class="no-result">Không tìm thấy kết quả.</p>
        </c:otherwise>
    </c:choose>

    <a href="<c:url value='/' />" class="back-link">← Quay lại trang chủ</a>
</div>
</body>
</html>
