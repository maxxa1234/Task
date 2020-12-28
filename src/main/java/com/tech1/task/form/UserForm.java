package com.tech1.task.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserForm {

    @NotEmpty
    private String name;

    @NotNull
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
