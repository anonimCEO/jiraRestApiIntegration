package com.company.jira.service;

import com.company.jira.model.jiraIssue.Issue;
import org.springframework.http.ResponseEntity;

public interface IssueService {
    Object createIssue(Issue issue);

    String deleteIssueById(String id);

    Object updateIssueById(Issue issue, String id);

    ResponseEntity<String> getIssueAssignedToUser(String name);
}
