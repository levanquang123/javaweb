<%@ include file="../common/header.jsp" %>
<div class="container mt-4">
    <h2>Trang chủ sinh viên</h2>
    <div class="list-group mt-3">
        <a href="${pageContext.request.contextPath}/sinhvien/form" class="list-group-item list-group-item-action">
            Khai báo thông tin tốt nghiệp
        </a>
        <a href="${pageContext.request.contextPath}/sinhvien/profile" class="list-group-item list-group-item-action">
            Xem thông tin cá nhân
        </a>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>