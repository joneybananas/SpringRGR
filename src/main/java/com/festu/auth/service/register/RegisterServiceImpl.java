package com.festu.auth.service.register;

import com.festu.auth.model.User;
import com.festu.auth.repository.UserRepository;
import com.festu.auth.service.register.arguments.RegisterUserArguments;
import com.festu.auth.service.token.AuthTokenService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RegisterServiceImpl implements RegisterService {

    UserRepository repository;

    @Override
    public User register(RegisterUserArguments arguments) {
        return repository.save(User.builder()
                                   .displayName(arguments.getDisplayName())
                                   .password(arguments.getPassword())
                                   .username(arguments.getUsername())
                                   .authorities(arguments.getAuthorities())
                                   .build());
    }

}
