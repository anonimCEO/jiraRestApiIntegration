package com.company.jira.service.Impl;

import com.company.jira.model.jiraSession.CurrentUser;
import com.company.jira.model.jiraSession.SessionResponse;
import com.company.jira.model.jiraSession.SessionValue;
import com.company.jira.service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.company.jira.utils.UrlPaths.CREATE_NEW_SESSION;
import static com.company.jira.utils.UrlPaths.GET_CURRENT_SESSION;

@Service
public class JiraServiceImplementation implements JiraService {

    @Autowired
    RestTemplate restTemplate;

    SessionValue sessionValue = new SessionValue();

    private String username;
    private String password;

    @Override
    public void getSession() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);
        HttpEntity request = new HttpEntity<>(body, headers);
        sessionValue.setSessionValue(restTemplate.postForEntity(CREATE_NEW_SESSION,
                request, SessionResponse.class).getBody().getSession().getValue());
    }

    @Override
    public ResponseEntity<CurrentUser> getCurrentUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Cookie", "JSESSIONID= " + sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity<>(headers);
        return restTemplate.exchange(GET_CURRENT_SESSION,
                HttpMethod.GET, request, CurrentUser.class);

    }
}
