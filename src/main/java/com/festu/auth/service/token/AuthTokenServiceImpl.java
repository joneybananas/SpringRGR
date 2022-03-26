package com.festu.auth.service.token;

import com.festu.auth.model.AuthToken;
import com.festu.auth.model.User;
import com.festu.auth.repository.AuthTokenRepository;
import com.festu.auth.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthTokenServiceImpl implements AuthTokenService {

    private final AuthTokenRepository repository;

    private final AuthService authService;

    //    @Value("${auth.minutes-inactivity-timeout}")
    private String MAX_USER_TOKEN_INACTIVITY_MIN = "30";

    @Override
    public void update(AuthToken token) {
        token.setLastAccessTime(LocalDateTime.now());
        this.repository.save(token);
        authService.loginUser(token.getUser());
    }

    @Override
    public void remove(AuthToken authToken) {
        this.repository.delete(authToken);
        authService.logout();
    }

    @Override
    public boolean isAuthTokenExpired(AuthToken token) {
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime lastAccessTime = token.getLastAccessTime();
        log.info(String.format("Validating is token %s expired of %s minutes", token.getId(), MAX_USER_TOKEN_INACTIVITY_MIN));
        return Math.abs(ChronoUnit.MINUTES.between(now, lastAccessTime)) > Integer.parseInt(MAX_USER_TOKEN_INACTIVITY_MIN);
    }

    @Override
    public AuthToken createToken(User loggedInUser) {
        if(loggedInUser == null) throw new BadCredentialsException("Invalid username or password");
        AuthToken token = AuthToken.builder()
                                   .user(loggedInUser)
                                   .build();

        this.repository.saveAndFlush(token);
        authService.loginUser(token.getUser());

        return token;
    }

    @Override
    public AuthToken findById(UUID id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void removeByUser(User user) {

        repository.removeByUser(user);
        authService.logout();
    }

}
