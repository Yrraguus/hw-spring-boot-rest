package com.example.hwspringbootrest.service;

import com.example.hwspringbootrest.domain.Authorities;
import com.example.hwspringbootrest.exception.InvalidCredentials;
import com.example.hwspringbootrest.exception.UnauthorizedUser;
import com.example.hwspringbootrest.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    UserRepository userRepository = new UserRepository();

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
