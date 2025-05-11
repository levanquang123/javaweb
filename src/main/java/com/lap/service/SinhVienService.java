package com.lap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lap.model.SinhVien;
import com.lap.repository.SinhVienRepository;

@Service
public class SinhVienService {

    private final SinhVienRepository sinhVienRepository;

    public SinhVienService(SinhVienRepository sinhVienRepository) {
        this.sinhVienRepository = sinhVienRepository;
    }

    public List <SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }

    public Optional <SinhVien> getSinhVienBySoCMND (String soCMND) {
        return sinhVienRepository.findById(soCMND);
    }

    public SinhVien saveSinhVien (SinhVien sinhVien) {
        return sinhVienRepository.save(sinhVien);
    }

    public void deleteSinhVien(String soCMND) {
        sinhVienRepository.deleteById(soCMND);
    }

    public List <SinhVien> searchSinhVien (String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return sinhVienRepository.findByHoTenContainingOrEmailContainingOrDiaChiContaining(keyword, keyword, keyword);
        }
        return sinhVienRepository.findAll();
    }
}
