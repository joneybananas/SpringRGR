package com.festu.meeting.actions.arguments;

import com.festu.meeting.model.UserEntry;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Getter
@Builder
public class CreateMeetingArguments {
    String title;
    UserEntry author;
    List<LocalDateTime> availableTime;
}
