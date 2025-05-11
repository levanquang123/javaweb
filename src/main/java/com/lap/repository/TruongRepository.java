package com.lap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lap.model.Truong;

public interface TruongRepository extends JpaRepository<Truong, String> {
    List<Truong> findByTenTruongContaining(String keyword);
}
