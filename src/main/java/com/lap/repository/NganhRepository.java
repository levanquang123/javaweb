package com.lap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lap.model.Nganh;

public interface NganhRepository extends JpaRepository<Nganh, String> {
    List<Nganh> findByTenNganhContaining(String keyword);

    List<Nganh> findByLoaiNganh(String loaiNganh);
}
