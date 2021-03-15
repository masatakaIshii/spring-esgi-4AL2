package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class UserService {
    private final UserStore userStore;
    private final UserConfig userConfig;

    // Inversion de control
    @Autowired
    UserService(UserStore userStore, UserConfig userConfig) {
        this.userStore = userStore;
        this.userConfig = userConfig;
    }

    void addUser(String username) {
        // Fail fast
        if (userStore.count() + 1 > userConfig.getMax()) {
            throw new IllegalStateException("Cannot add more users");
        }

        userStore.store(username);
        System.out.println("Stored " + username);
    }

    List<String> findAll() {
        return userStore.findAll();
    }
}
