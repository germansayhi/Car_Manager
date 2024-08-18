package com.vti.kshop.kshopdemo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname",length = 100, nullable = false)
    private String fullname;

    @Column(name = "username",length = 100, nullable = false, unique = true)
    private String username;

    @Column(name = "email",length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number",length = 100, nullable = false, unique = true)
    private String phonenumber;

    @Column(name = "password",length = 100, unique = true, nullable = false)
    private String password;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDate updatedAt;

    public enum Role{
        EMPLOYEE,MANAGER
    }

}
