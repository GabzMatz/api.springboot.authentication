package org.api.authetication.service;


import org.api.authetication.domain.user.User;
import org.api.authetication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User findUserByName(String name) {
        return repository.findByName(name);
    }



    public List<User> showAllUsers() {
        return repository.findAll();
    }

}
