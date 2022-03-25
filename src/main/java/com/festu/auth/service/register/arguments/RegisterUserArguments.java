package com.festu.auth.service.register.arguments;

import lombok.Builder;
import lombok.Getter;

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
}
