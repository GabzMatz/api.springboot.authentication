package org.api.authetication.service;


import org.api.authetication.domain.user.User;
import org.api.authetication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    private UserRepository userRepository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }

}
