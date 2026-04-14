package com.echorun.app.service;

import com.echorun.app.model.User;

public interface UserService {

    User register(String username, String rawPassword, String email);

    User login(String username, String rawPassword);
}
