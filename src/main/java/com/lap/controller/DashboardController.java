package com.lap.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lap.model.User;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/auth/login";
        
        if ("SINHVIEN".equals(user.getRole())) {
            return "sinhvien/dashboard";
        } else {
            return "bogiaoduc/dashboard";
        }
    }
}