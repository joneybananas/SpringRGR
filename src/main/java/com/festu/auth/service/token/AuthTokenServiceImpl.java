package com.festu.auth.service.token;

import com.festu.auth.model.AuthToken;
import com.festu.auth.model.User;
import com.festu.auth.repository.AuthTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthTokenServiceImpl implements AuthTokenService {

    private final AuthTokenRepository repository;

    @Value("${auth.minutes_inactivity_timeout}")
    private Integer MAX_USER_TOKEN_INACTIVITY_MIN;

    @Override
    public void update(AuthToken token) {
        token.setLastAccessTime(LocalDateTime.now());
        this.repository.save(token);
    }

    @Override
    public void remove(AuthToken authToken) {
        this.repository.delete(authToken);
    }

    @Override
    public boolean isAuthTokenExpired(AuthToken token) {
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime lastAccessTime = token.getLastAccessTime();

        return Math.abs(ChronoUnit.MINUTES.between(now, lastAccessTime)) > MAX_USER_TOKEN_INACTIVITY_MIN;
    }

    @Override
    public AuthToken createToken(User loggedInUser) {
        AuthToken token = AuthToken.builder()
                                   .user(loggedInUser)
                                   .build();

        this.repository.saveAndFlush(token);

        return token;
    }

    @Override
    public AuthToken findById(UUID id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void removeByUser(User user) {
        repository.removeByUser(user);
    }

}
