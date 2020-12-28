package com.tech1.task.dto;

import java.util.List;

public class UserNamesDto {
    private List<String> names;

    public UserNamesDto(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
