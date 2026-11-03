package com.spriingboot.student_managment_system.dto;

public class UserRegisterResponseDto {

    private String username;
    private String message;

    public UserRegisterResponseDto(String username, String message) {
        this.username = username;
        this.message = message;
    }
    public UserRegisterResponseDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
