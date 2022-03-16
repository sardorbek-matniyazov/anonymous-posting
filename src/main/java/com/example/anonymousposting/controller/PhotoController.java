package com.example.anonymousposting.controller;

import com.example.anonymousposting.service.AttachmentService;
import lombok.AllArgsConstructor;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@AllArgsConstructor
public class PhotoController {
    private final AttachmentService service;

    @GetMapping(value = "/getImage/{name}")
    public void getPhoto(@PathVariable(value = "name") String name, HttpServletResponse response) throws IOException {
        File file = service.getFile(name);
        FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
    }

}
