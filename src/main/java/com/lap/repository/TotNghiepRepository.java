package com.lap.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lap.model.TotNghiep;
import com.lap.model.TotNghiep.TotNghiepId;

public interface TotNghiepRepository extends JpaRepository<TotNghiep, TotNghiepId> {
    List<TotNghiep> findBySinhVien_SoCMND (String soCMND);
    List<TotNghiep> findByNganh_MaNganh (String maNganh);
    List<TotNghiep> findByTruong_MaTruong (String maTruong);
    List<TotNghiep> findByHeTN (String heTN);
    List<TotNghiep> findByLoaiTN (String loaiTN);
    List<TotNghiep> findByNgayTNBetween (Date startDate, Date endDate);
}
