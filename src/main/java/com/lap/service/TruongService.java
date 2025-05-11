package com.lap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lap.model.Truong;
import com.lap.repository.TruongRepository;

@Service
public class TruongService {
    private final TruongRepository truongRepository;

    public TruongService(TruongRepository truongRepository) {
        this.truongRepository = truongRepository;
    }

    public List<Truong> getAllTruong() {
        return truongRepository.findAll();
    }

    public Optional <Truong> getTruongById (String maTruong) {
        return truongRepository.findById(maTruong);
    }

    public Truong saveTruong(Truong truong) {
        return truongRepository.save(truong);
    }
}
