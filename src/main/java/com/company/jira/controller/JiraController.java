package com.company.jira.controller;

import com.company.jira.model.jiraSession.CurrentUser;
import com.company.jira.service.Impl.JiraServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class JiraController {

    private final JiraServiceImplementation jiraServiceImplementation;

    @PostMapping("/auth")
    public void createSession() {
        jiraServiceImplementation.getSession();
    }

    @GetMapping("/getUser")
    public ResponseEntity<CurrentUser> getCurrentUser() {

        return jiraServiceImplementation.getCurrentUser();
    }
}
