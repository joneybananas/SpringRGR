package com.festu.lib.mapper;

import com.festu.auth.model.User;
import com.festu.meeting.model.UserEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Mapper
public interface UserMapper {
    @Mapping(target = "name", source = "displayName")
    UserEntry toUserEntry(User user);
}
