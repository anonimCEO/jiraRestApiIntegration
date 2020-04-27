package com.company.jira.service.Impl;

import com.company.jira.model.jiraIssue.CreateIssueResponse;
import com.company.jira.model.jiraIssue.Issue;
import com.company.jira.model.jiraSession.SessionValue;
import com.company.jira.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.company.jira.utils.UrlPaths.ISSUE_URL_API;
import static com.company.jira.utils.UrlPaths.JQL_FILTER;

@Service
public class IssueServiceImplementation implements IssueService {

    @Autowired
    JiraServiceImplementation jiraServiceImplementation;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public Object createIssue(Issue issue) {
        jiraServiceImplementation.getSession();
        SessionValue sessionValue = jiraServiceImplementation.sessionValue;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity(issue, headers);

        return restTemplate.exchange(ISSUE_URL_API, HttpMethod.POST,
                request, CreateIssueResponse.class);
    }

    @Override
    public String deleteIssueById(String id) {

        jiraServiceImplementation.getSession();
        SessionValue sessionValue = jiraServiceImplementation.sessionValue;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity(headers);
        restTemplate.exchange(ISSUE_URL_API.concat(id),
                HttpMethod.DELETE, request, String.class);

        return "The issue with id: " + id + " was deleted";
    }

    @Override
    public Object updateIssueById(Issue issue, String id) {
        jiraServiceImplementation.getSession();
        SessionValue sessionValue = jiraServiceImplementation.sessionValue;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity(issue, headers);
        restTemplate.exchange(ISSUE_URL_API.concat(id),
                HttpMethod.PUT, request, String.class);

        return "The issue with id: " + id + " was successfully updated";
    }

    @Override
    public ResponseEntity<String> getIssueAssignedToUser(String name) {
        jiraServiceImplementation.getSession();
        SessionValue sessionValue = jiraServiceImplementation.sessionValue;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity(name, headers);
        return restTemplate.exchange(JQL_FILTER.concat(name), HttpMethod.GET, request, String.class);


    }
}
