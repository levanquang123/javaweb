package com.lap.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lap.model.Nganh;
import com.lap.model.SinhVien;
import com.lap.model.TotNghiep;
import com.lap.model.Truong;
import com.lap.service.NganhService;
import com.lap.service.SinhVienService;
import com.lap.service.TotNghiepService;
import com.lap.service.TruongService;

@Controller
@RequestMapping("/sinhvien")
public class SinhVienController {

    private final SinhVienService sinhVienService;

    private final TotNghiepService totNghiepService;

    private final TruongService truongService;

    private final NganhService nganhService;

    public SinhVienController(SinhVienService sinhVienService, TotNghiepService totNghiepService, TruongService truongService, NganhService nganhService) {
        this.sinhVienService = sinhVienService;
        this.totNghiepService = totNghiepService;
        this.truongService = truongService;
        this.nganhService = nganhService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("sinhVien", new SinhVien());
        model.addAttribute("totNghiep", new TotNghiep());
        model.addAttribute("truongList", truongService.getAllTruong());
        model.addAttribute("nganhList", nganhService.getAllNganh());
        return "sinhvien/form";
    }

    @PostMapping("/save")
    public String saveSinhVien(
            @ModelAttribute SinhVien sinhVien,
            @ModelAttribute TotNghiep totNghiep,
            @RequestParam(name = "maTruong") String maTruong,
            @RequestParam(name ="maNganh") String maNganh,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("truongList", truongService.getAllTruong());
            model.addAttribute("nganhList", nganhService.getAllNganh());
            return "sinhvien/form";
        }

        // Kiểm tra dữ liệu bắt buộc
        if (sinhVien.getSoCMND() == null || sinhVien.getSoCMND().isEmpty() ||
                maTruong == null || maTruong.isEmpty() ||
                maNganh == null || maNganh.isEmpty()) {
            model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin bắt buộc (SoCMND, MaTruong, MaNganh)");
            model.addAttribute("truongList", truongService.getAllTruong());
            model.addAttribute("nganhList", nganhService.getAllNganh());
            return "sinhvien/form";
        }

        // Kiểm tra ngày tốt nghiệp
        if (totNghiep.getNgayTN() != null) {
            Date currentDate = new Date();
            if (totNghiep.getNgayTN().after(currentDate)) {
                model.addAttribute("error", "Ngày tốt nghiệp không thể là ngày trong tương lai");
                model.addAttribute("truongList", truongService.getAllTruong());
                model.addAttribute("nganhList", nganhService.getAllNganh());
                return "sinhvien/form";
            }
        }

        // Lưu thông tin sinh viên
        sinhVienService.saveSinhVien(sinhVien);

        // Thiết lập thông tin tốt nghiệp
        Truong truong = truongService.getTruongById(maTruong).orElse(null);
        Nganh nganh = nganhService.getNganhById(maNganh).orElse(null);

        totNghiep.setSinhVien(sinhVien);
        totNghiep.setTruong(truong);
        totNghiep.setNganh(nganh);

        // Lưu thông tin tốt nghiệp
        totNghiepService.saveTotNghiep(totNghiep);

        return "sinhvien/success";
    }
}
