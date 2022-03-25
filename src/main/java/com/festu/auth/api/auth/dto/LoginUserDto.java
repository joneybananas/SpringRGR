package com.festu.auth.api.auth.dto;

import lombok.Getter;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Getter
public class LoginUserDto {
    String username;
    String password;
}
