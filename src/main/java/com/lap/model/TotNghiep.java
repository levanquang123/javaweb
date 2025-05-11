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
@Table(name = "TOT_NGHIEP")
public class TotNghiep {
    
    @EmbeddedId
    private TotNghiepId id;
    
    @ManyToOne
    @MapsId("soCMND")
    @JoinColumn(name = "SoCMND")
    private SinhVien sinhVien;
    
    @ManyToOne
    @MapsId("maTruong")
    @JoinColumn(name = "MaTruong")
    private Truong truong;
    
    @ManyToOne
    @MapsId("maNganh")
    @JoinColumn(name = "MaNganh")
    private Nganh nganh;
    
    @Column(name = "HeTN", length = 50)
    private String heTN;
    
    @Column(name = "NgayTN")
    @Temporal(TemporalType.DATE)
    private Date ngayTN;
    
    @Column(name = "LoaiTN", length = 50)
    private String loaiTN;
    
    // Constructors
    public TotNghiep() {}
    
    public TotNghiep(SinhVien sinhVien, Truong truong, Nganh nganh, String heTN, Date ngayTN, String loaiTN) {
        this.id = new TotNghiepId(sinhVien.getSoCMND(), truong.getMaTruong(), nganh.getMaNganh());
        this.sinhVien = sinhVien;
        this.truong = truong;
        this.nganh = nganh;
        this.heTN = heTN;
        this.ngayTN = ngayTN;
        this.loaiTN = loaiTN;
    }
    
    // Getters and Setters
    public TotNghiepId getId() {
        return id;
    }
    
    public void setId(TotNghiepId id) {
        this.id = id;
    }
    
    public SinhVien getSinhVien() {
        return sinhVien;
    }
    
    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
        if (this.id == null) {
            this.id = new TotNghiepId();
        }
        this.id.setSoCMND(sinhVien.getSoCMND());
    }
    
    public Truong getTruong() {
        return truong;
    }
    
    public void setTruong(Truong truong) {
        this.truong = truong;
        if (this.id == null) {
            this.id = new TotNghiepId();
        }
        this.id.setMaTruong(truong.getMaTruong());
    }
    
    public Nganh getNganh() {
        return nganh;
    }
    
    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
        if (this.id == null) {
            this.id = new TotNghiepId();
        }
        this.id.setMaNganh(nganh.getMaNganh());
    }
    
    public String getHeTN() {
        return heTN;
    }
    
    public void setHeTN(String heTN) {
        this.heTN = heTN;
    }
    
    public Date getNgayTN() {
        return ngayTN;
    }
    
    public void setNgayTN(Date ngayTN) {
        this.ngayTN = ngayTN;
    }
    
    public String getLoaiTN() {
        return loaiTN;
    }
    
    public void setLoaiTN(String loaiTN) {
        this.loaiTN = loaiTN;
    }
    
    @Embeddable
    public static class TotNghiepId implements Serializable {
        @Column(name = "SoCMND")
        private String soCMND;
        
        @Column(name = "MaTruong")
        private String maTruong;
        
        @Column(name = "MaNganh")
        private String maNganh;
        
        // Constructors
        public TotNghiepId() {}
        
        public TotNghiepId(String soCMND, String maTruong, String maNganh) {
            this.soCMND = soCMND;
            this.maTruong = maTruong;
            this.maNganh = maNganh;
        }
        
        // Getters and Setters
        public String getSoCMND() {
            return soCMND;
        }
        
        public void setSoCMND(String soCMND) {
            this.soCMND = soCMND;
        }
        
        public String getMaTruong() {
            return maTruong;
        }
        
        public void setMaTruong(String maTruong) {
            this.maTruong = maTruong;
        }
        
        public String getMaNganh() {
            return maNganh;
        }
        
        public void setMaNganh(String maNganh) {
            this.maNganh = maNganh;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TotNghiepId that = (TotNghiepId) o;
            return Objects.equals(soCMND, that.soCMND) &&
                   Objects.equals(maTruong, that.maTruong) &&
                   Objects.equals(maNganh, that.maNganh);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(soCMND, maTruong, maNganh);
        }
    }
}
