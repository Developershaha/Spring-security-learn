package com.spriingboot.student_managment_system.controller;

import com.spriingboot.student_managment_system.dto.UserRegisterDto;
import com.spriingboot.student_managment_system.dto.UserRegisterResponseDto;
import com.spriingboot.student_managment_system.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    private AuthService authService;


    public UserController(AuthService authService){
        this.authService=authService;
    }


    @GetMapping("/hello")
    public String sayHello(Authentication authentication){
        return "Hello i am "+authentication.getName();
    }
    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(@RequestBody UserRegisterDto userRegisterDto){
      UserRegisterResponseDto userRegisterResponseDto=  authService.register(userRegisterDto);
      return ResponseEntity.ok(userRegisterResponseDto);

    };
}
