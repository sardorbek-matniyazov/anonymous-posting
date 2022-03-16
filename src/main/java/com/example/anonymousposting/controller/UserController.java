package com.example.anonymousposting.controller;

import com.example.anonymousposting.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserController {
    private final MemberService service;
}
