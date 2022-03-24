package com.festu.meeting.service.meeting;

import com.festu.meeting.model.Meeting;
import com.festu.meeting.service.meeting.arguments.CreateMeetingArguments;
import com.festu.meeting.service.meeting.arguments.SearchMeetingArguments;
import com.festu.meeting.service.meeting.arguments.UpdateMeetingArguments;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created on 3/24/2022
 *
 * @author Fedor Ishchenko
 */
public interface MeetingService {
    Meeting create(@NotNull CreateMeetingArguments arguments);
    Meeting update(@NotNull UUID id, @NotNull UpdateMeetingArguments arguments);
    Optional<Meeting> get(@NotNull UUID id);
    Meeting getExisting(@NotNull UUID id);
    List<Meeting> list(@NonNull SearchMeetingArguments arguments);
    void delete(@NotNull UUID id);
}
