package com.lap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lap.model.Nganh;
import com.lap.repository.NganhRepository;

@Service
public class NganhService {
    private NganhRepository nganhRepository;

    public NganhService(NganhRepository nganhRepository) {
        this.nganhRepository = nganhRepository;
    }

    public List<Nganh> getAllNganh() {
        return nganhRepository.findAll();
    }

    public Optional<Nganh> getNganhById (String maNganh) {
        return nganhRepository.findById(maNganh);
    }

    public Nganh saveNganh(Nganh nganh) {
        return nganhRepository.save(nganh);
    }
}
