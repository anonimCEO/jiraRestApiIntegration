package com.company.jira.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class UrlPaths {

    public static final String CREATE_NEW_SESSION = "https://uatjira.endava.com/rest/auth/1/session";
    public static final String GET_CURRENT_SESSION = "https://uatjira.endava.com/rest/auth/1/session";
    public static final String ISSUE_URL_API = "https://uatjira.endava.com/rest/api/2/issue/";
    public static final String JQL_FILTER = "https://uatjira.endava.com/rest/api/2/search?jql=project=IP AND assignee=";

}
