package com.dibs.webapp.springboot_web.models.dto;

import com.dibs.webapp.springboot_web.models.User;

public class UserDto {
    private String tittle;
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
