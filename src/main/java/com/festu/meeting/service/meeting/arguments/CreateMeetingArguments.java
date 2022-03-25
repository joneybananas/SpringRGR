package com.festu.meeting.service.meeting.arguments;

import com.festu.meeting.model.UserEntry;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class CreateMeetingArguments {
    String title;
    UserEntry author;
    List<LocalDateTime> availableTime;
}
