package com.company.jira.model.jiraSession;

import lombok.Data;

@Data
public class LoginInfo {
    private int failedLoginCount;
    private int loginCount;
    private String lastFailedLoginTime;
    private String previousLoginTime;

}


