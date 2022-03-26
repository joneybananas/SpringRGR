package com.festu.meeting.actions;

import com.festu.auth.model.User;
import com.festu.auth.service.auth.AuthService;
import com.festu.lib.dto.SimpleObjectValue;
import com.festu.lib.mapper.UserMapper;
import com.festu.meeting.config.LocalDateTimeConfig;
import com.festu.meeting.model.Meeting;
import com.festu.meeting.service.meeting.MeetingService;
import com.festu.meeting.service.vote.arguments.VoteMeetingArguments;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VoteMeetingAction {

    AuthService authService;

    UserMapper userMapper;

    MeetingService meetingService;

    public VoteMeetingArguments execute(UUID id, SimpleObjectValue<String> dateTime) {
        User loginUser = authService.getLoginUser();
        Meeting meeting = meetingService.getExisting(id);
        return VoteMeetingArguments.builder()
                                   .meeting(meeting)
                                   .user(userMapper.toUserEntry(loginUser))
                                   .time(LocalDateTime.parse(dateTime.getValue(), LocalDateTimeConfig.DATE_TIME_FORMATTER))
                                   .build();
    }

}
