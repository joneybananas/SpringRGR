package com.festu.meeting.service.vote.arguments;

import com.festu.meeting.model.Meeting;
import com.festu.meeting.model.UserEntry;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Getter
@Builder
public class VoteMeetingArguments {
    Meeting meeting;
    UserEntry user;
    LocalDateTime time;
}
