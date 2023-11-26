package com.example.borism.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    private int id;
    private String login;
    private byte[] passw;

    public User(String login, byte[] passw) {
        this.login = login;
        this.passw = passw;
    }
}
