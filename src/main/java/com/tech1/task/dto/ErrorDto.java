package com.tech1.task.dto;

public class ErrorDto {

    private String field;
    private String message;

    public ErrorDto(String field, String errors) {
        this.field = field;
        this.message = errors;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
