package com.company.jira.model.jiraIssue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateIssueResponse {
    private String id;
    private String key;
    private String self;

}
