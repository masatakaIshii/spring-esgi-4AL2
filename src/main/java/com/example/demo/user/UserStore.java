package com.example.demo.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
class UserStore {
    private final List<String> userDb = new ArrayList<>();

    void store(String userName) {
        userDb.add(userName);
    }

    int count() {
        return userDb.size();
    }

    List<String> findAll() {
        return new ArrayList<>(userDb); // pour ne pas envoyer la référence mais une copie de la référence
        // car à l'extérieur, il est possible d'appeler users.clear(), donc il va aussi vider la liste dans UserStore
    }
}
