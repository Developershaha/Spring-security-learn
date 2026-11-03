package com.spriingboot.student_managment_system.service;

import com.spriingboot.student_managment_system.dto.UserRegisterDto;
import com.spriingboot.student_managment_system.dto.UserRegisterResponseDto;
import com.spriingboot.student_managment_system.entity.Role;
import com.spriingboot.student_managment_system.entity.User;
import com.spriingboot.student_managment_system.repository.RoleRepository;
import com.spriingboot.student_managment_system.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserRepository userRepository;

    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
    public AuthService(UserRepository userRepository,RoleRepository roleRepository){
//        this.passwordEncoder=passwordEncoder;
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
    }

    public UserRegisterResponseDto register(UserRegisterDto registerRequestDto) {
        User user=new User(); // create new user
        user.setUsername(registerRequestDto.getUsername());
        String encodedPassword=passwordEncoder.encode(registerRequestDto.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        Role role=roleRepository.findByName("ROLE_USER").get();

        user.getRoles().add(role);
        userRepository.save(user);

        UserRegisterResponseDto responseDto=new UserRegisterResponseDto();
        responseDto.setMessage("User saved successfully ");
        responseDto.setUsername(user.getUsername());
        return responseDto;


    }
}
