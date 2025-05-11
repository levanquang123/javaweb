package com.lap.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "CONG_VIEC")
public class CongViec {

    @EmbeddedId
    private CongViecId id;

    @ManyToOne
    @MapsId("soCMND")
    @JoinColumn(name = "SoCMND")
    private SinhVien sinhVien;

    @ManyToOne
    @JoinColumn(name = "MaNganh")
    private Nganh nganh;

    @Column(name = "TenCongViec", length = 100)
    private String tenCongViec;

    @Column(name = "TenCongTy", length = 100)
    private String tenCongTy;

    @Column(name = "DiaChiCongTy", length = 200)
    private String diaChiCongTy;

    @Column(name = "ThoiGianLamViec", length = 100)
    private String thoiGianLamViec;

    // Constructors
    public CongViec() {}

    public CongViec(SinhVien sinhVien, Date ngayVaoCongTy, Nganh nganh, String tenCongViec,
                    String tenCongTy, String diaChiCongTy, String thoiGianLamViec) {
        this.id = new CongViecId(sinhVien.getSoCMND(), ngayVaoCongTy);
        this.sinhVien = sinhVien;
        this.nganh = nganh;
        this.tenCongViec = tenCongViec;
        this.tenCongTy = tenCongTy;
        this.diaChiCongTy = diaChiCongTy;
        this.thoiGianLamViec = thoiGianLamViec;
    }

    // Getters and Setters
    public CongViecId getId() {
        return id;
    }

    public void setId(CongViecId id) {
        this.id = id;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
        if (this.id == null) {
            this.id = new CongViecId();
        }
        this.id.setSoCMND(sinhVien.getSoCMND());
    }

    public Date getNgayVaoCongTy() {
        return id != null ? id.getNgayVaoCongTy() : null;
    }

    public void setNgayVaoCongTy(Date ngayVaoCongTy) {
        if (this.id == null) {
            this.id = new CongViecId();
        }
        this.id.setNgayVaoCongTy(ngayVaoCongTy);
    }

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getDiaChiCongTy() {
        return diaChiCongTy;
    }

    public void setDiaChiCongTy(String diaChiCongTy) {
        this.diaChiCongTy = diaChiCongTy;
    }

    public String getThoiGianLamViec() {
        return thoiGianLamViec;
    }

    public void setThoiGianLamViec(String thoiGianLamViec) {
        this.thoiGianLamViec = thoiGianLamViec;
    }

    @Embeddable
    public static class CongViecId implements Serializable {
        @Column(name = "SoCMND")
        private String soCMND;

        @Column(name = "NgayVaoCongTy")
        @Temporal(TemporalType.DATE)
        private Date ngayVaoCongTy;

        // Constructors
        public CongViecId() {}

        public CongViecId(String soCMND, Date ngayVaoCongTy) {
            this.soCMND = soCMND;
            this.ngayVaoCongTy = ngayVaoCongTy;
        }

        // Getters and Setters
        public String getSoCMND() {
            return soCMND;
        }

        public void setSoCMND(String soCMND) {
            this.soCMND = soCMND;
        }

        public Date getNgayVaoCongTy() {
            return ngayVaoCongTy;
        }

        public void setNgayVaoCongTy(Date ngayVaoCongTy) {
            this.ngayVaoCongTy = ngayVaoCongTy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CongViecId that = (CongViecId) o;
            return Objects.equals(soCMND, that.soCMND) &&
                    Objects.equals(ngayVaoCongTy, that.ngayVaoCongTy);
        }

        @Override
        public int hashCode() {
            return Objects.hash(soCMND, ngayVaoCongTy);
        }
    }
}
