package com.festu.meeting.actions;

import com.festu.auth.service.auth.AuthService;
import com.festu.lib.mapper.UserMapper;
import com.festu.meeting.api.meeting.dto.CreateMeetingDto;
import com.festu.meeting.model.UserEntry;
import com.festu.meeting.service.meeting.arguments.CreateMeetingArguments;
import lombok.RequiredArgsConstructor;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@RequiredArgsConstructor
public class CreateMeetingAction {

    private final UserMapper userMapper;

    private final AuthService authService;

    public CreateMeetingArguments execute(CreateMeetingDto dto) {
        UserEntry user = userMapper.toUserEntry(authService.getLoginUser());
        return CreateMeetingArguments.builder()
                                     .author(user)
                                     .title(dto.getTitle())
                                     .availableTime(dto.getAvailableTime())
                                     .build();
    }

}
