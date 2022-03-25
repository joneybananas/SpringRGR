package com.festu.auth.api.register.dto;

import lombok.Getter;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Getter
public class RegisterUserDto {

    String username;

    String displayName;

    String password;
}
