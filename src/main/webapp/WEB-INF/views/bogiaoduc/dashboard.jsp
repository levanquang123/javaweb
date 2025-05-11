<%@ include file="../common/header.jsp" %>
<div class="container mt-4">
    <h2>Trang quản trị Bộ Giáo Dục</h2>
    <div class="row mt-3">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Thống kê</h5>
                    <a href="${pageContext.request.contextPath}/bogiaoduc/thongke" class="btn btn-primary">
                        Xem báo cáo
                    </a>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Tìm kiếm</h5>
                    <a href="${pageContext.request.contextPath}/timkiem/totnghiep" class="btn btn-primary">
                        Tra cứu tốt nghiệp
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>