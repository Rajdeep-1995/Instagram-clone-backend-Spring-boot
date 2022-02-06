package com.instagramclone.controller;

import com.instagramclone.entity.Role;
import com.instagramclone.entity.User;
import com.instagramclone.payload.SignUpDto;
import com.instagramclone.respository.RoleRepository;
import com.instagramclone.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

                if(userRepository.existsByUsername(signUpDto.getUsername()) ||
                    userRepository.existsByEmail(signUpDto.getEmail()) ||
                        userRepository.existsByPhoneNumber(signUpDto.getPhoneNumber())){
                    return new ResponseEntity<>("User already exist", HttpStatus.BAD_REQUEST);
                }

        User user = new User();
                Role role = new Role();
                role.setRoleType("ROLE_USER");
                roleRepository.save(role);


                user.setFirstName(signUpDto.getFirstName());
                user.setLastName(signUpDto.getLastName());
                user.setUsername(signUpDto.getUsername());
                user.setEmail(signUpDto.getEmail());
                user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
                user.setCreatedAt(new Date());
                user.setGender(signUpDto.getGender());
                user.setPhoneNumber(signUpDto.getPhoneNumber());
                user.setBirthDate(new Date());
//                Role roles = roleRepository.findByRoleType("ROLE_USER").get();
//                user.setRoles(Collections.singleton(roles));

                userRepository.save(user);

                return new ResponseEntity<>("User has been registered successfully.",HttpStatus.CREATED);
    }
}
