package com.company.jira.model.jiraIssue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fields {

    private Project project;
    private String summary;
    private IssueType issuetype;
    private Assignee assignee;
    private Reporter reporter;
    private List<String> labels;
    private String description;

}
