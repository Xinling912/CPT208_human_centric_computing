package com.echorun.app.service.impl;

import com.echorun.app.model.User;
import com.echorun.app.repository.UserRepository;
import com.echorun.app.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User register(String username, String rawPassword, String email) {
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("用户名已存在");
        }
        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(passwordEncoder.encode(rawPassword));
        user.setEmail(email);
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User login(String username, String rawPassword) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("用户名或密码错误"));
        if (!passwordEncoder.matches(rawPassword, user.getPasswordHash())) {
            throw new IllegalArgumentException("用户名或密码错误");
        }
        return user;
    }
}
