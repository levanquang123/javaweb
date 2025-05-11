package com.lap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TRUONG")
public class Truong {
    @Id
    @Column(name = "MaTruong", length = 20)
    private String maTruong;
    
    @Column(name = "TenTruong", nullable = false, length = 100)
    private String tenTruong;
    
    @Column(name = "DiaChi", length = 200)
    private String diaChi;
    
    @Column(name = "SoDT", length = 15)
    private String soDT;
    
    // Constructors
    public Truong() {}
    
    public Truong(String maTruong, String tenTruong, String diaChi, String soDT) {
        this.maTruong = maTruong;
        this.tenTruong = tenTruong;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }
    
    // Getters and Setters
    public String getMaTruong() {
        return maTruong;
    }
    
    public void setMaTruong(String maTruong) {
        this.maTruong = maTruong;
    }
    
    public String getTenTruong() {
        return tenTruong;
    }
    
    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }
    
    public String getDiaChi() {
        return diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public String getSoDT() {
        return soDT;
    }
    
    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
    
    @Override
    public String toString() {
        return "Truong [maTruong=" + maTruong + ", tenTruong=" + tenTruong + ", diaChi=" + diaChi + ", soDT=" + soDT + "]";
    }
}
