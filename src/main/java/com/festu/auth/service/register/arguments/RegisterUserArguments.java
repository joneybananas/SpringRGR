package com.festu.auth.service.register.arguments;

import com.festu.auth.model.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Getter
@Builder
public class RegisterUserArguments {
    String username;
    String displayName;
    String password;
    List<Role> authorities;
}
