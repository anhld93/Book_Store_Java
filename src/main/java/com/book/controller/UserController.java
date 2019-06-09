package com.book.controller;

import com.book.dto.UserDTO;
import com.book.model.User;
import com.book.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/", produces = "application/json")
    public void hello() {
        System.out.println("Hello Word");
    }

    @PostMapping(path = "/login", consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Object> userLogin(@RequestBody UserDTO userDTO) {
        Optional<User> user = userService.findUserByUserNameAndPassword(userDTO.getUserName(), userDTO.getPassword());
        if(user == null) {
            return null;
        }
        return ok(user);
    }

    @GetMapping(path = "/me")
    public ResponseEntity currentUser(@AuthenticationPrincipal UserDetails userDetails) {
        Map<Object, Object> model = new HashMap<>();
        model.put("username", userDetails.getUsername());
        model.put("roles", userDetails.getAuthorities()
                                    .stream()
                                    .map(a ->(a).getAuthority())
                                    .collect(toList()));
        return ok(model);
    }
}
