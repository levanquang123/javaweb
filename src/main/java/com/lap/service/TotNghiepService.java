package com.lap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lap.model.TotNghiep;
import com.lap.model.TotNghiep.TotNghiepId;
import com.lap.repository.TotNghiepRepository;

@Service
public class TotNghiepService {

    private final TotNghiepRepository totNghiepRepository;

    public TotNghiepService(TotNghiepRepository totNghiepRepository) {
        this.totNghiepRepository = totNghiepRepository;
    }

    public List<TotNghiep> getAllTotNghiep() {
        return totNghiepRepository.findAll();
    }

    public Optional<TotNghiep> getTotNghiepById(TotNghiepId id) {
        return totNghiepRepository.findById(id);
    }

    public TotNghiep saveTotNghiep(TotNghiep totNghiep) {
        return totNghiepRepository.save(totNghiep);
    }

    public List<TotNghiep> getTotNghiepBySoCMND(String soCMND) {
        return totNghiepRepository.findBySinhVien_SoCMND(soCMND);
    }

    public List<TotNghiep> getTotNghiepByMaTruong(String maTruong) {
        return totNghiepRepository.findByTruong_MaTruong(maTruong);
    }

    public List<TotNghiep> getTotNghiepByMaNganh(String maNganh) {
        return totNghiepRepository.findByNganh_MaNganh(maNganh);
    }
}
