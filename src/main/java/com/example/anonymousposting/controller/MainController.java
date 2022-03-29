package com.example.anonymousposting.controller;

import com.example.anonymousposting.service.ArticleService;
import com.example.anonymousposting.service.CommentService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
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
    private final CommentService commentService;

    @GetMapping(value = {"/home", "/"})
    public String mainTemplate(@NotNull Model model){
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

    @PostMapping(value = "/view/{id}")
    public String setView(@PathVariable Integer id,
                          Model model,
                          @RequestParam(value = "action") String action,
                          @RequestParam(value = "comment", required = false) String comment){
        if (action.equals("send")){
            commentService.saveComment(id, comment);
            return "redirect:/home";
        }
        articleService.setView(model, id);
        return "viewPage";
    }
}
