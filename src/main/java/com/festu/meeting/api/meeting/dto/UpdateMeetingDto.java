package com.festu.meeting.api.meeting.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * Created on 3/24/2022
 *
 * @author Fedor Ishchenko
 */
@Getter
@Setter
@Builder
public class UpdateMeetingDto {
    @NotBlank
    String title;
    @NotNull
    List<String> availableTime;
}
