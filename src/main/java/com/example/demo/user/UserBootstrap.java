package com.example.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class UserBootstrap {
    private final UserService userService;

    @EventListener
    public void on(ApplicationReadyEvent event) {
        for (int i = 0; i < 2; i++) {
            userService.addUser("Bootstraped-" + i);
        }
    }
}
