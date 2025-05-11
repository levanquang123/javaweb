package com.lap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lap.model.SinhVien;

public interface SinhVienRepository extends JpaRepository<SinhVien, String> {
    List<SinhVien> findByHoTenContaining(String keyword);
    List<SinhVien> findByHoTenContainingOrEmailContainingOrDiaChiContaining(String hoTen, String email, String diaChi);
    List<SinhVien> findByEmailContaining(String email);
}