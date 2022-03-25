package com.festu.auth.api.register.mapper;

import com.festu.auth.api.register.dto.RegisterUserDto;
import com.festu.auth.service.register.arguments.RegisterUserArguments;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Mapper(uses = {AuthoritiesMapper.class})
public interface RegisterMapper {

    @Mapping(target = "authorities", qualifiedByName = "getAuthorities")
    RegisterUserArguments toRegisterArguments(RegisterUserDto dto);

}
