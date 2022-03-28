package com.example.anonymousposting.controller;

import com.example.anonymousposting.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
public class MainController {
    private final ArticleService articleService;

    @GetMapping(value = "/")
    public String mainTemplate(Model model){
        model.addAttribute("posts", articleService.getAll());
        return "index";
    }

    @GetMapping(value = "/createUser")
    public String createUserTemplate(){
        return "createUser";
    }

    @GetMapping(value = "/posting")
    public String createTemplate(){
        return "create";
    }

    @GetMapping(value = "/about")
    public String aboutTemplate(){
        return "create";
    }

    @GetMapping(value = "/comment")
    public String comment(){
        return "comment";
    }

    @PostMapping(value = "/view/{id}")
    public String setView(@PathVariable String id){
        System.out.println("1");
        return "viewPage";
    }

    @PostMapping(value = "/view/{id}", params="action=more")
    public String sendComment(@PathVariable String id){
        System.out.println("2");
        return "viewPage";
    }

    @PostMapping(value = "/view/{id}", params="action=send")
    public String moreView(@PathVariable String id, @RequestParam(value = "comment") String comment){
        System.out.println("3" + comment);
        return "viewPage";
    }
    
}
