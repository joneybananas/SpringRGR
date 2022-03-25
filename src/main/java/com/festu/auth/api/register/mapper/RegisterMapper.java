package com.festu.auth.api.register.mapper;

import com.festu.auth.api.register.dto.RegisterUserDto;
import com.festu.auth.service.register.arguments.RegisterUserArguments;
import org.mapstruct.Mapper;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Mapper
public interface RegisterMapper {

    RegisterUserArguments toRegisterArguments(RegisterUserDto dto);

}
