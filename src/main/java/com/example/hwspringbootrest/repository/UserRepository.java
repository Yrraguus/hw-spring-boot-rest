package com.example.hwspringbootrest.repository;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static com.example.hwspringbootrest.repository.Authorities.*;

/*
Requests for testing
###
GET http://localhost:8080/authorize?user=Vasya&password=123
Accept: application/json
###
GET http://localhost:8080/authorize?user=Petya&password=123
Accept: application/json
###
GET http://localhost:8080/authorize?user=Petya&password=456
Accept: application/json
###
GET http://localhost:8080/authorize?user=Kolya&password=789
Accept: application/json
###
GET http://localhost:8080/authorize
Accept: application/json
 */
public class UserRepository {

    public ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    public UserRepository() {
        users.put("Vasya", new User("Vasya", "123", List.of(READ)));
        users.put("Petya", new User("Petya", "456", List.of(READ, WRITE, DELETE)));
        users.put("Kolya", new User("Kolya", "789", Collections.emptyList()));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (users.containsKey(user) && users.get(user).getPassword().equals(password)) {
            return users.get(user).getAuthorities();
        } else return Collections.emptyList();
    }
}