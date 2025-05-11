<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm kiếm thông tin tốt nghiệp và việc làm</title>
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

        h1, h2 {
            color: #333;
        }

        h2 {
            margin-top: 30px;
            border-bottom: 1px solid #ddd;
            padding-bottom: 10px;
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

        .info-section {
            background-color: #f9f9f9;
            padding: 15px;
            border-radius: 5px;
            margin-bottom: 20px;
        }

        .info-row {
            display: flex;
            margin-bottom: 10px;
        }

        .info-label {
            font-weight: bold;
            width: 150px;
        }

        .info-value {
            flex: 1;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Tìm kiếm thông tin tốt nghiệp và việc làm</h1>

    <form action="<c:url value='/timkiem/totnghiep' />" method="post" class="search-form">
        <input type="text" name="soCMND" placeholder="Nhập số CMND/CCCD..." value="${soCMND}"/>
        <button type="submit">Tìm kiếm</button>
    </form>

    <c:if test="${not empty sinhVien}">
        <div class="info-section">
            <h2>Thông tin sinh viên</h2>
            <div class="info-row">
                <div class="info-label">Số CMND/CCCD:</div>
                <div class="info-value">${sinhVien.soCMND}</div>
            </div>
            <div class="info-row">
                <div class="info-label">Họ tên:</div>
                <div class="info-value">${sinhVien.hoTen}</div>
            </div>
            <div class="info-row">
                <div class="info-label">Email:</div>
                <div class="info-value">${sinhVien.email}</div>
            </div>
            <div class="info-row">
                <div class="info-label">Số điện thoại:</div>
                <div class="info-value">${sinhVien.soDT}</div>
            </div>
            <div class="info-row">
                <div class="info-label">Địa chỉ:</div>
                <div class="info-value">${sinhVien.diaChi}</div>
            </div>
        </div>

        <h2>Thông tin tốt nghiệp</h2>
        <c:choose>
            <c:when test="${not empty totNghieps}">
                <table>
                    <thead>
                    <tr>
                        <th>Mã trường</th>
                        <th>Tên trường</th>
                        <th>Mã ngành</th>
                        <th>Tên ngành</th>
                        <th>Hệ tốt nghiệp</th>
                        <th>Ngày tốt nghiệp</th>
                        <th>Loại tốt nghiệp</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${totNghieps}" var="tn">
                        <tr>
                            <td>${tn.truong.maTruong}</td>
                            <td>${tn.truong.tenTruong}</td>
                            <td>${tn.nganh.maNganh}</td>
                            <td>${tn.nganh.tenNganh}</td>
                            <td>${tn.heTN}</td>
                            <td><fmt:formatDate value="${tn.ngayTN}" pattern="dd/MM/yyyy"/></td>
                            <td>${tn.loaiTN}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p class="no-result">Không tìm thấy thông tin tốt nghiệp.</p>
            </c:otherwise>
        </c:choose>

        <h2>Thông tin việc làm</h2>
        <c:choose>
            <c:when test="${not empty congViecs}">
                <table>
                    <thead>
                    <tr>
                        <th>Mã ngành</th>
                        <th>Tên ngành</th>
                        <th>Tên công việc</th>
                        <th>Tên công ty</th>
                        <th>Địa chỉ công ty</th>
                        <th>Ngày vào công ty</th>
                        <th>Thời gian làm việc</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${congViecs}" var="cv">
                        <tr>
                            <td>${cv.nganh.maNganh}</td>
                            <td>${cv.nganh.tenNganh}</td>
                            <td>${cv.tenCongViec}</td>
                            <td>${cv.tenCongTy}</td>
                            <td>${cv.diaChiCongTy}</td>
                            <td><fmt:formatDate value="${cv.id.ngayVaoCongTy}" pattern="dd/MM/yyyy"/></td>
                            <td>${cv.thoiGianLamViec}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p class="no-result">Không tìm thấy thông tin việc làm.</p>
            </c:otherwise>
        </c:choose>
    </c:if>

    <c:if test="${empty sinhVien && not empty soCMND}">
        <p class="no-result">Không tìm thấy sinh viên với số CMND/CCCD: ${soCMND}</p>
    </c:if>

    <a href="<c:url value='/' />" class="back-link">← Quay lại trang chủ</a>
</div>
</body>
</html>
