package com.festu.meeting.api.meeting.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created on 3/24/2022
 *
 * @author Fedor Ishchenko
 */
@Getter
@Setter
@NoArgsConstructor
public class UpdateMeetingDto {
    @NotBlank
    String title;
    @NotNull
    List<String> availableTime;
}
