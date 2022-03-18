package com.example.anonymousposting.controller;

import com.example.anonymousposting.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {
    private final ArticleService service;

    @GetMapping(value = "/")
    public String main(Model model){
        model.addAttribute("posts", service.getall());
        return "index";
    }

    @GetMapping(value = "/createUser")
    public String createUser(){
        return "createUser";
    }
}
