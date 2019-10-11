package com.imane.basic.controller;

import com.imane.basic.entity.Role;
import com.imane.basic.entity.User;
import com.imane.basic.repository.RoleRepository;
import com.imane.basic.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/public")
@Slf4j
public class PublicController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public PublicController(UserRepository userRepository,
                            RoleRepository roleRepository,
                            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(path = "/home")
    public ResponseEntity<?> index() {
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> post) {
        if (post.get("username") != null && post.get("password") != null) {
            Optional<Role> op_role = roleRepository.findByName("ROLE_USER");
            Role role = op_role.orElseGet(() -> roleRepository.save(Role.builder().name("ROLE_USER").build()));

            User user = User.builder()
                    .username(post.get("username"))
                    .password(passwordEncoder.encode(post.get("password")))
                    .role(role)
                    .build();
            userRepository.save(user);
            return ResponseEntity.ok().body(Map.of("status", "success"));
        } else
            return ResponseEntity.badRequest().build();
    }
}
