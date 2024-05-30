package com.example.admingiadien.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class showController {
    @GetMapping("/index")
    public String index() {
        return "Admin/index";
    }

    @GetMapping("pages")
    public String showPages(){
        return "Admin/page";
    }
}
