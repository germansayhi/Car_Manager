package com.vti.kshop.kshopdemo.service;

import com.vti.kshop.kshopdemo.dto.UserDto;
import com.vti.kshop.kshopdemo.form.UserCreatedForm;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.security.Principal;

public interface UserService  {
    UserDto create(UserCreatedForm form);

    void updatePassword(Long id, String password);

    UserDto login(Principal principal);
}
