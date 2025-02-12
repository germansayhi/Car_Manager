package com.vti.kshop.kshopdemo.controller;

import com.vti.kshop.kshopdemo.dto.UserDto;
import com.vti.kshop.kshopdemo.form.UserCreatedForm;
import com.vti.kshop.kshopdemo.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
public class UserController {
    private UserService userService;

    @PostMapping("/api/v1/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody @Valid UserCreatedForm form){
        return userService.create(form);
    }

    @GetMapping("/api/v1/login")
    public UserDto login(Principal principal) {
      return userService.login(principal);
    }

    @PatchMapping("/api/v1/users/{id}/newpassword")
    public void updatePassword(
            @PathVariable Long id,
            @RequestBody String password){
        userService.updatePassword(id, password);
    }
}
