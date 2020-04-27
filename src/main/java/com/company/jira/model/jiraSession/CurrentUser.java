package com.company.jira.model.jiraSession;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrentUser {
    private String self;
    private String name;
    private LoginInfo loginInfo;

}
