package com.vti.kshop.kshopdemo.repository;

import com.vti.kshop.kshopdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameOrEmail(String username, String email);

    // Thay đổi mất khẩu
    @Query("UPDATE User SET password = :password WHERE id =:id")
    void updatePassword(@Param("id") Long id, @Param("password") String password);
}
