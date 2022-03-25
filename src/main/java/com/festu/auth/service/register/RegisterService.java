package com.festu.auth.service.register;

import com.festu.auth.model.User;
import com.festu.auth.service.register.arguments.RegisterUserArguments;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
public interface RegisterService {
    User register(RegisterUserArguments arguments);
}
