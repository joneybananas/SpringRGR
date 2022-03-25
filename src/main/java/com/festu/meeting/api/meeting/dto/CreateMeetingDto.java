package com.festu.meeting.api.meeting.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 3/24/2022
 *
 * @author Fedor Ishchenko
 */
@Getter
@Setter
public class CreateMeetingDto {

    @NotBlank
    String title;

    @NotBlank
    List<LocalDateTime> availableTime;

}
