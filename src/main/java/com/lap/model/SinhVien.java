package com.lap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SINHVIEN")
public class SinhVien {
    @Id
    @Column(name = "SoCMND", length = 20)
    private String soCMND;
    
    @Column(name = "HoTen", nullable = false, length = 100)
    private String hoTen;
    
    @Column(name = "Email", length = 100)
    private String email;
    
    @Column(name = "SoDT", length = 15)
    private String soDT;
    
    @Column(name = "DiaChi", length = 200)
    private String diaChi;
    
    // Constructors
    public SinhVien() {}
    
    public SinhVien(String soCMND, String hoTen, String email, String soDT, String diaChi) {
        this.soCMND = soCMND;
        this.hoTen = hoTen;
        this.email = email;
        this.soDT = soDT;
        this.diaChi = diaChi;
    }
    
    // Getters and Setters
    public String getSoCMND() {
        return soCMND;
    }
    
    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }
    
    public String getHoTen() {
        return hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSoDT() {
        return soDT;
    }
    
    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
    
    public String getDiaChi() {
        return diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    @Override
    public String toString() {
        return "SinhVien [soCMND=" + soCMND + ", hoTen=" + hoTen + ", email=" + email + ", soDT=" + soDT + ", diaChi=" + diaChi + "]";
    }
}
