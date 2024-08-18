package com.vti.kshop.kshopdemo.service;

import com.vti.kshop.kshopdemo.dto.UserDto;
import com.vti.kshop.kshopdemo.entity.User;
import com.vti.kshop.kshopdemo.form.UserCreatedForm;
import com.vti.kshop.kshopdemo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto create(UserCreatedForm form) {
        var user = modelMapper.map(form, User.class);
        var encodedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encodedPassword);
        var savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsernameOrEmail(username, username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                AuthorityUtils.NO_AUTHORITIES);
    }
}
