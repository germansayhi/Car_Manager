package com.vti.kshop.kshopdemo.dto;

import com.vti.kshop.kshopdemo.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private String fullname;
    private String username;
    private String email;
    private String phonenumber;
    private User.Role role;
}