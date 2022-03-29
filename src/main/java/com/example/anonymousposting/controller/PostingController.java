package com.example.anonymousposting.controller;

import com.example.anonymousposting.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class PostingController {
    private final ArticleService articleService;

    @PostMapping(value = "/newPost")
    public String post(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model){
        return "redirect:/view/" + articleService.saveAndSet(file, request, model);
    }
}
