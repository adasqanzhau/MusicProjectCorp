package org.example.dto;

public class UserDto {
    private String name;
    private Long admin;

    public UserDto(){

    }

    public UserDto(String name, Long admin) {
        this.name = name;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAdmin() {
        return admin;
    }

    public void setAdmin(Long admin) {
        this.admin = admin;
    }

    public UserDto(String name) {
        this.name = name;
    }
}
