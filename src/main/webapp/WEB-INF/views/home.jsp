<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý Sinh viên tốt nghiệp</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .menu {
            display: flex;
            justify-content: center;
            margin-top: 30px;
        }
        .menu-item {
            margin: 0 10px;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
        .menu-item:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Hệ thống Quản lý Sinh viên tốt nghiệp</h1>

    <div class="menu">
        <a href="<c:url value='/sinhvien/form' />" class="menu-item">Khai báo thông tin sinh viên tốt nghiệp</a>
        <a href="<c:url value='/timkiem/coban' />" class="menu-item">Tìm kiếm thông tin cơ bản</a>
        <a href="<c:url value='/timkiem/totnghiep' />" class="menu-item">Tìm kiếm thông tin tốt nghiệp</a>
    </div>
</div>
</body>
</html>
