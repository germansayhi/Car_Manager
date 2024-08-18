package com.vti.kshop.kshopdemo.repository;

import com.vti.kshop.kshopdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameOrEmail(String username, String email);
}
