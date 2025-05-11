<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${pageTitle}</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="/">Hệ thống quản lý tốt nghiệp</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto">
                <c:if test="${not empty sessionScope.user}">
                    <li class="nav-item">
                        <a class="nav-link" href="/dashboard">Trang chủ</a>
                    </li>
                    <c:if test="${sessionScope.user.role eq 'SINHVIEN'}">
                        <li class="nav-item">
                            <a class="nav-link" href="/sinhvien/form">Khai báo tốt nghiệp</a>
                        </li>
                    </c:if>
                </c:if>
            </ul>
            <c:if test="${not empty sessionScope.user}">
                <span class="navbar-text me-3">Xin chào, ${sessionScope.user.soCCCD}</span>
                <a href="/logout" class="btn btn-outline-light">Đăng xuất</a>
            </c:if>
        </div>
    </div>
</nav>
<div class="container">