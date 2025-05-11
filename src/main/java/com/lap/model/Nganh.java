package com.lap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NGANH")
public class Nganh {
    @Id
    @Column(name = "MaNganh", length = 20)
    private String maNganh;
    
    @Column(name = "TenNganh", nullable = false, length = 100)
    private String tenNganh;
    
    @Column(name = "LoaiNganh", length = 50)
    private String loaiNganh;
    
    // Constructors
    public Nganh() {}
    
    public Nganh(String maNganh, String tenNganh, String loaiNganh) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.loaiNganh = loaiNganh;
    }
    
    // Getters and Setters
    public String getMaNganh() {
        return maNganh;
    }
    
    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }
    
    public String getTenNganh() {
        return tenNganh;
    }
    
    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }
    
    public String getLoaiNganh() {
        return loaiNganh;
    }
    
    public void setLoaiNganh(String loaiNganh) {
        this.loaiNganh = loaiNganh;
    }
    
    @Override
    public String toString() {
        return "Nganh [maNganh=" + maNganh + ", tenNganh=" + tenNganh + ", loaiNganh=" + loaiNganh + "]";
    }
}
