package com.festu.meeting.service.meeting.arguments;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 3/24/2022
 *
 * @author Fedor Ishchenko
 */
@Getter
@Builder
public class UpdateMeetingArguments {
    String title;
    List<LocalDateTime> availableTime;
}
