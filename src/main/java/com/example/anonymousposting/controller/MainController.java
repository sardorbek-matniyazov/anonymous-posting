package com.example.anonymousposting.controller;

import com.example.anonymousposting.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/view")
    public String viewTemplate(Model model, @RequestParam("id") Integer id){
        articleService.setView(model, id);
        return "viewPage";
    }

    @GetMapping(value = "/posting")
    public String createTemplate(){
        return "create";
    }

    @GetMapping(value = "/about")
    public String aboutTemplate(){
        return "create";
    }

}
