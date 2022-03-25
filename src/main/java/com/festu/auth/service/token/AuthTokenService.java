package com.festu.auth.service.token;

import com.festu.auth.model.AuthToken;
import com.festu.auth.model.User;

import java.util.UUID;

public interface AuthTokenService {
    void update(AuthToken token);

    void remove(AuthToken authToken);

    boolean isAuthTokenExpired(AuthToken token);

    AuthToken createToken(User loggedInUser);

    AuthToken findById(UUID id);

    void removeByUser(User user);
}
