package com.echorun.app.controller;

import com.echorun.app.model.User;
import com.echorun.app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        String email = body.get("email");
        User user = userService.register(username, password, email);
        return ResponseEntity.ok(Map.of(
                "id", user.getId(),
                "username", user.getUsername()
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        User user = userService.login(username, password);
        return ResponseEntity.ok(Map.of(
                "id", user.getId(),
                "username", user.getUsername()
        ));
    }
}
