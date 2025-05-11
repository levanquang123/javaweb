package com.lap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lap.model.CongViec;
import com.lap.model.CongViec.CongViecId;
import com.lap.repository.CongViecRepository;

@Service
public class CongViecService {

    private final CongViecRepository congViecRepository;

    public CongViecService(CongViecRepository congViecRepository) {
        this.congViecRepository = congViecRepository;
    }

    public List<CongViec> getAllCongViec() {
        return congViecRepository.findAll();
    }

    public Optional<CongViec> getCongViecById(CongViecId id) {
        return congViecRepository.findById(id);
    }

    public CongViec saveCongViec(CongViec congViec) {
        return congViecRepository.save(congViec);
    }

    public List<CongViec> getCongViecBySoCMND(String soCMND) {
        return congViecRepository.findBySinhVien_SoCMND(soCMND);
    }

    public List<CongViec> getCongViecByMaNganh(String maNganh) {
        return congViecRepository.findByNganh_MaNganh(maNganh);
    }
}
