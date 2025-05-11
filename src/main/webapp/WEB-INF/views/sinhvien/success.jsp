<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Lưu thông tin thành công</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 20px;
    }
    .container {
      max-width: 600px;
      margin: 0 auto;
      padding: 20px;
      border: 1px solid #ddd;
      border-radius: 5px;
      text-align: center;
    }
    h1 {
      color: #4CAF50;
    }
    .success-message {
      margin: 20px 0;
      font-size: 18px;
    }
    .btn {
      display: inline-block;
      padding: 10px 20px;
      background-color: #4CAF50;
      color: white;
      text-decoration: none;
      border-radius: 4px;
      margin: 10px;
    }
    .btn:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Thành công!</h1>
  <p class="success-message">Thông tin sinh viên tốt nghiệp đã được lưu thành công.</p>

  <div>
    <a href="<c:url value='/sinhvien/form' />" class="btn">Tiếp tục nhập thông tin</a>
    <a href="<c:url value='/' />" class="btn">Quay lại trang chủ</a>
  </div>
</div>
</body>
</html>
