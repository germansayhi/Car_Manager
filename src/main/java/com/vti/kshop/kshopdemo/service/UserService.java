package com.vti.kshop.kshopdemo.service;

import com.vti.kshop.kshopdemo.dto.UserDto;
import com.vti.kshop.kshopdemo.form.UserCreatedForm;

public interface UserService {
    UserDto create(UserCreatedForm form);
}
