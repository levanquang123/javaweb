package com.lap.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lap.model.CongViec;
import com.lap.model.SinhVien;
import com.lap.model.TotNghiep;
import com.lap.service.CongViecService;
import com.lap.service.SinhVienService;
import com.lap.service.TotNghiepService;

@Controller
@RequestMapping("/timkiem")
public class TimKiemController {

    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private TotNghiepService totNghiepService;

    @Autowired
    private CongViecService congViecService;

    @GetMapping("/coban")
    public String showSearchBasicForm() {
        return "timkiem/coban";
    }

    @PostMapping("/coban")
    public String searchBasic(@RequestParam(name = "keyword") String keyword, Model model) {
        List<SinhVien> sinhViens = new ArrayList<>();

        if (keyword != null && !keyword.isEmpty()) {
            // Tìm kiếm theo từ khóa
            sinhViens = sinhVienService.searchSinhVien(keyword);
        } else {
            // Nếu không có từ khóa, hiển thị tất cả
            sinhViens = sinhVienService.getAllSinhVien();
        }

        model.addAttribute("sinhViens", sinhViens);
        model.addAttribute("keyword", keyword);

        return "timkiem/coban";
    }

    @GetMapping("/totnghiep")
    public String showSearchGraduationForm() {
        return "timkiem/totnghiep";
    }

    @PostMapping("/totnghiep")
    public String searchGraduation(@RequestParam(name = "soCMND") String soCMND, Model model) {
        Optional<SinhVien> sinhVien = sinhVienService.getSinhVienBySoCMND(soCMND);

        if (sinhVien.isPresent()) {
            List<TotNghiep> totNghieps = totNghiepService.getTotNghiepBySoCMND(soCMND);
            List<CongViec> congViecs = congViecService.getCongViecBySoCMND(soCMND);

            model.addAttribute("sinhVien", sinhVien.get());
            model.addAttribute("totNghieps", totNghieps);
            model.addAttribute("congViecs", congViecs);
        }

        model.addAttribute("soCMND", soCMND);

        return "timkiem/totnghiep";
    }
}
