package com.festu.auth.api.auth;

import com.festu.auth.api.auth.action.LoginAction;
import com.festu.auth.api.auth.dto.LoginUserDto;
import com.festu.auth.service.auth.AuthService;
import com.festu.auth.service.token.AuthTokenService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {

    AuthService authService;

    LoginAction loginAction;

    AuthTokenService tokenService;

    @PostMapping("login")
    public UUID login(@RequestBody LoginUserDto loginUserDto) {
        return tokenService.createToken(loginAction.execute(loginUserDto.getUsername(),
                                                            loginUserDto.getPassword())
                           ).getId();

    }

    @PostMapping("logout")
    public void logout() {
        authService.logout();
    }

}
