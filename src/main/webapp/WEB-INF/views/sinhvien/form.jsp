<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Khai báo thông tin sinh viên tốt nghiệp</title>
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
    }
    .form-group {
      margin-bottom: 15px;
    }
    label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
    }
    input[type="text"],
    input[type="email"],
    input[type="date"],
    select {
      width: 100%;
      padding: 8px;
      border: 1px solid #ddd;
      border-radius: 4px;
      box-sizing: border-box;
    }
    .required:after {
      content: " *";
      color: red;
    }
    .error {
      color: red;
      font-size: 14px;
      margin-top: 5px;
    }
    .submit-btn {
      padding: 10px 20px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
    }
    .submit-btn:hover {
      background-color: #45a049;
    }
    .back-link {
      display: block;
      margin-top: 20px;
      text-decoration: none;
      color: #333;
    }
    .section-title {
      border-bottom: 2px solid #4CAF50;
      padding-bottom: 5px;
      margin-top: 30px;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Khai báo thông tin sinh viên tốt nghiệp</h1>

  <c:if test="${not empty error}">
    <div class="error">${error}</div>
  </c:if>

  <form action="<c:url value='/sinhvien/save' />" method="post">
    <h2 class="section-title">Thông tin sinh viên</h2>

    <div class="form-group">
      <label for="soCMND" class="required">Số CMND/CCCD</label>
      <input type="text" id="soCMND" name="soCMND" required />
    </div>

    <div class="form-group">
      <label for="hoTen" class="required">Họ tên</label>
      <input type="text" id="hoTen" name="hoTen" required />
    </div>

    <div class="form-group">
      <label for="email">Email</label>
      <input type="email" id="email" name="email" />
    </div>

    <div class="form-group">
      <label for="soDT">Số điện thoại</label>
      <input type="text" id="soDT" name="soDT" />
    </div>

    <div class="form-group">
      <label for="diaChi">Địa chỉ</label>
      <input type="text" id="diaChi" name="diaChi" />
    </div>

    <h2 class="section-title">Thông tin tốt nghiệp</h2>

    <div class="form-group">
      <label for="maTruong" class="required">Trường</label>
      <select id="maTruong" name="maTruong" required>
        <option value="">-- Chọn trường --</option>
        <c:forEach items="${truongList}" var="truong">
          <option value="${truong.maTruong}">${truong.tenTruong}</option>
        </c:forEach>
      </select>
    </div>

    <div class="form-group">
      <label for="maNganh" class="required">Ngành</label>
      <select id="maNganh" name="maNganh" required>
        <option value="">-- Chọn ngành --</option>
        <c:forEach items="${nganhList}" var="nganh">
          <option value="${nganh.maNganh}">${nganh.tenNganh}</option>
        </c:forEach>
      </select>
    </div>

    <div class="form-group">
      <label for="heTN">Hệ tốt nghiệp</label>
      <input type="text" id="heTN" name="heTN" />
    </div>

    <div class="form-group">
      <label for="ngayTN">Ngày tốt nghiệp</label>
      <input type="date" id="ngayTN" name="ngayTN" />
    </div>

    <div class="form-group">
      <label for="loaiTN">Loại tốt nghiệp</label>
      <input type="text" id="loaiTN" name="loaiTN" />
    </div>

    <button type="submit" class="submit-btn">Lưu thông tin</button>
  </form>

  <a href="<c:url value='/' />" class="back-link">← Quay lại trang chủ</a>
</div>
</body>
</html>
