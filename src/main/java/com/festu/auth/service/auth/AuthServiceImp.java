package com.festu.auth.service.auth;

import com.festu.auth.model.User;
import org.springframework.stereotype.Service;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Service
public class AuthServiceImp implements AuthService {

    private User loginUser;

    @Override
    public User getLoginUser() {
        return loginUser;
    }

    @Override
    public void loginUser(User user) {
        this.loginUser = user;
    }

    @Override
    public void logout() {
        loginUser = null;
    }

}
