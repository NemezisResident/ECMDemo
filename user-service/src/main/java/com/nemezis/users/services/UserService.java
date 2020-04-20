package com.nemezis.users.services;

import com.nemezis.users.dao.UserRepository;
import com.nemezis.users.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service
 */
@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAlUsersl() {
        return userRepository.findAll();
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
}
