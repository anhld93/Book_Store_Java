package com.book.controller;

import com.book.dao.PrivilegeDao;
import com.book.dao.RoleDao;
import com.book.dto.UserDTO;
import com.book.model.User;
import com.book.security.JwtTokenProvider;
import com.book.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    private PrivilegeDao privilegeDao;

    @Autowired
    private RoleDao roleDao;

    @PostMapping(path = "/login", consumes = "application/json",
            produces = "application/json")
    public ResponseEntity login(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUserName();
        String password = userDTO.getPassword();
//        password = passwordEncoder.encode(password);
//        User admin = new User();
//        admin.setUsername("admin");
//        admin.setPassword("admin1234");
//        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
//        admin.setEmail("admin@email.com");
//
//        Privilege writePrivilege = new Privilege();
//        writePrivilege.setName("WRITE_PRIVILEGE");
//
//
//        Privilege readPrivilege = new Privilege();
//        readPrivilege.setName("READ_PRIVILEGE");
//
//        List<Privilege> adminPrivileges = Arrays.asList(
//                readPrivilege, writePrivilege);
//
//        Role role = new Role();
//        role.setName("ROLE_ADMIN");
//        role.setPrivileges(adminPrivileges);
//
//
//        List<Role> roles = new ArrayList<>();
//        roles.add(role);
//        admin.setRoles(roles);
//        userService.save(admin);


        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        User user = userService.findUserByUserName(username);

        String token = jwtTokenProvider.createToken(username, user.getRoles());

        Map<Object, Object> model = new HashMap<>();
        model.put("userName", username);
        model.put("role", user.getRoles().get(0).getName());
        model.put("token", token);

        return ok(model);
    }

}
