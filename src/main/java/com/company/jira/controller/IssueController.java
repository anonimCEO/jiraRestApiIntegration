package com.company.jira.controller;

import com.company.jira.model.jiraIssue.Issue;
import com.company.jira.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/issue")
public class IssueController {

    private final IssueService issueService;

    @PostMapping(value = "/create")
    public Object createIssue(@RequestBody Issue issue) {
        return issueService.createIssue(issue);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteIssueById(@PathVariable String id) {
        return issueService.deleteIssueById(id);
    }

    @PutMapping(value = "/update/{id}")
    public Object updateIssueById(@RequestBody Issue issue, @PathVariable String id) {
        return issueService.updateIssueById(issue, id);
    }

    @GetMapping(value = "/user/{name}")
    public ResponseEntity<String> getAllIssuesByUser(@PathVariable String name) {
        return issueService.getIssueAssignedToUser(name);
    }
}
