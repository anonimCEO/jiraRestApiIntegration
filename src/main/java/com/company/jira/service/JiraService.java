package com.company.jira.service;

import com.company.jira.model.jiraSession.CurrentUser;
import org.springframework.http.ResponseEntity;

public interface JiraService {

    void getSession();

    ResponseEntity<CurrentUser> getCurrentUser();
}
