package com.example.anonymousposting.controller;

import com.example.anonymousposting.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class PostingController {
    private final ArticleService articleService;

    @PostMapping(value = "/newPost")
    public String post(MultipartFile file, HttpServletRequest request){
        Integer id = articleService.save(file, request);
        return "redirect:/post/" + id;
    }

    @GetMapping(value = "/posting")
    public String postingTemplate(){
        return "create";
    }
}
