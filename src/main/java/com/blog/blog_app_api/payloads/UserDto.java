package com.blog.blog_app_api.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 3, message = "Username must be minimum of 4 characters.")
    private String name;

    @Email(message = "Email address is not valid.")
    private String email;

    @NotEmpty(message = "Please Enter password.")
    @Size(min = 4, max = 12, message = "Password must be between 4 to 12 characters.")
    private String password;

    @NotEmpty(message = "Enter about section.")
    private String about;

}
