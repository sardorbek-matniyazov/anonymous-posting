package com.example.anonymousposting.service;

import com.example.anonymousposting.entity.Article;
import com.example.anonymousposting.entity.Attachment;
import com.example.anonymousposting.entity.Member;
import com.example.anonymousposting.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;
    private final MemberService memberService;
    private final AttachmentService attachmentService;

    @SneakyThrows
    public Article save(MultipartFile file, HttpServletRequest request) {
        Attachment photo = attachmentService.save(file);
        Member member = memberService.getByNameAndPassword(
                request.getParameter("username"),
                request.getParameter("password")
        );

        return repository.save(Article.builder()
                .postText(request.getParameter("textarea"))
                .title(request.getParameter("title"))
                .imageName(photo.getFileName())
                .date(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .build());
    }

    public List<Article> getAll() {
        return repository.findAll(Sort.by("reaction"));
    }

    public void setView(Model model, Integer id) {
        Article byId = repository.getById(id);
        model.addAttribute("title", byId.getTitle());
        model.addAttribute("imageName", byId.getImageName());
        model.addAttribute("main", byId.getPostText());
    }

    public Integer saveAndSet(MultipartFile file, HttpServletRequest request, Model model) {
        Article saved = save(file, request);
        model.addAttribute("title", saved.getTitle());
        model.addAttribute("main", saved.getPostText());
        model.addAttribute("imageName", saved.getImageName());
        return saved.getId();
    }
}
