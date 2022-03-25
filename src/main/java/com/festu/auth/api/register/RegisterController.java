package com.festu.auth.api.register;

import com.festu.auth.api.register.dto.RegisterUserDto;
import com.festu.auth.api.register.mapper.RegisterMapper;
import com.festu.auth.service.register.RegisterService;
import com.festu.auth.service.register.arguments.RegisterUserArguments;
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
public class RegisterController {

    RegisterService service;
    RegisterMapper mapper;
    AuthTokenService authTokenService;

    @PostMapping("register")
    public UUID register(@RequestBody RegisterUserDto registerUserDto) {
        RegisterUserArguments arguments = mapper.toRegisterArguments(registerUserDto);
        return authTokenService.createToken(service.register(arguments)).getId();
    }

}
