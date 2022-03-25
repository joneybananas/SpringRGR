package com.festu.auth.api.auth;

import com.festu.auth.api.auth.dto.LoginUserDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("login")
    public void login(@RequestBody LoginUserDto loginUserDto) {

    }

}
