package com.festu.auth.service.auth;

import com.festu.auth.model.User;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
public interface AuthService {
    User getLoginUser();
    void loginUser(User user);
}
