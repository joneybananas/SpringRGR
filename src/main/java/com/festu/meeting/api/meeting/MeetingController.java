package com.festu.meeting.api.meeting;

import com.festu.lib.dto.SimpleObjectValue;
import com.festu.meeting.actions.CreateMeetingAction;
import com.festu.meeting.actions.VoteMeetingAction;
import com.festu.meeting.api.meeting.dto.*;
import com.festu.meeting.api.meeting.mapper.MeetingMapper;
import com.festu.meeting.model.Meeting;
import com.festu.meeting.service.meeting.MeetingService;
import com.festu.meeting.service.meeting.arguments.CreateMeetingArguments;
import com.festu.meeting.service.meeting.arguments.SearchMeetingArguments;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("meeting")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MeetingController {

    MeetingService metingService;

    MeetingMapper meetingMapper;

    CreateMeetingAction createMeetingAction;

    @GetMapping("list")
    public List<MeetingListDto> list(SearchMeetingDto searchDto) {
        SearchMeetingArguments searchArguments = meetingMapper.toSearchArguments(searchDto);

        List<Meeting> meetings = metingService.list(searchArguments);

        return meetings.stream()
                       .map(meetingMapper::toListDto)
                       .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public MeetingDto get(@PathVariable UUID id) {
        return meetingMapper.toDto(metingService.getExisting(id));
    }


    @PostMapping("create")
    public MeetingDto create(@RequestBody @Valid CreateMeetingDto createMeetingDto) {
        CreateMeetingArguments createMeetingActionArguments = meetingMapper.toCreateArguments(createMeetingDto);
        CreateMeetingArguments createMeetingArguments = createMeetingAction.execute(createMeetingActionArguments);
        Meeting meeting = metingService.create(createMeetingArguments);
        return meetingMapper.toDto(meeting);
    }

    @PostMapping("{id}/update")
    public MeetingDto update(@PathVariable UUID id, @Valid @RequestBody UpdateMeetingDto updateMeetingDto) {
        Meeting meeting = metingService.update(id, meetingMapper.toUpdateArguments(updateMeetingDto));
        return meetingMapper.toDto(meeting);
    }

    @PostMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        metingService.delete(id);
    }

}
