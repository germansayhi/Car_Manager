package com.vti.kshop.kshopdemo.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserCreatedForm {
    @NotBlank(message = "User fullname must not be blank")
    @Length(max =50, message = "User fullname has max 100 character")
    private String fullname;

    @NotBlank(message = "User username must not be blank")
    @Length(max =50, message = "User username has max 100 character")
    private String username;

    @NotBlank(message = "User email must not be blank")
    @Length(max =50, message = "User email  has max 100 character")
    @Email(message = "User email is not valid")
    private String email;

    @NotBlank(message = "User phone_number must not be blank")
    @Length(max =10, message = "User phone_number has max 10 character")
    private String phonenumber;

    @NotBlank(message = "User password must not be blank")
    @Length(
            min =6,max =12,
            message = "User password length must between 6 and 12 character")
    private String password;
}
