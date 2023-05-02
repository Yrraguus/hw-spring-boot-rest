package com.example.hwspringbootrest.repository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class User {
    @NotBlank
    @Size(min = 2, max = 20)
    private String login;
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;
    private List<Authorities> authorities;

    public User(String login, String password, List<Authorities> authorities) {
        this.login = login;
        this.password = password;
        this.authorities = authorities;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }
}
