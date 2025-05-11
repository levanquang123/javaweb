package com.lap.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lap.model.CongViec;
import com.lap.model.CongViec.CongViecId;

public interface CongViecRepository extends JpaRepository<CongViec, CongViecId> {
    List<CongViec> findBySinhVien_SoCMND(String soCMND);
    List<CongViec> findByNganh_MaNganh(String maNganh);
    List<CongViec> findByTenCongTyContaining(String keyword);
    List<CongViec> findByTenCongViecContaining(String keyword);
    List<CongViec> findById_NgayVaoCongTyBetween(Date startDate, Date endDate);
}
