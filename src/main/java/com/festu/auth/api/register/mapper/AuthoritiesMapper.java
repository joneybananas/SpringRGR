package com.festu.auth.api.register.mapper;

import com.festu.auth.model.Role;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Component
public class AuthoritiesMapper {

    @Named("getAuthorities")
    public List<Role> getAuthorities() {
        return new ArrayList<>();
    }

}
