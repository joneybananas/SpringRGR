package com.festu.meeting.api.meeting.mapper;

import com.festu.meeting.api.meeting.dto.*;
import com.festu.meeting.model.Meeting;
import com.festu.meeting.service.meeting.arguments.CreateMeetingArguments;
import com.festu.meeting.service.meeting.arguments.SearchMeetingArguments;
import com.festu.meeting.service.meeting.arguments.UpdateMeetingArguments;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created on 3/24/2022
 *
 * @author Fedor Ishchenko
 */
@Mapper(uses = {TimeMapper.class})
public interface MeetingMapper {

    MeetingDto toDto(Meeting meeting);

    @Mapping(target = "totalVotes", source = "votesAmount")
    MeetingListDto toListDto(Meeting meeting);

    @Mapping(target = "availableTime", qualifiedByName = "toLocalDateTime")
    CreateMeetingArguments toCreateArguments(CreateMeetingDto createMeetingDto);

    UpdateMeetingArguments toUpdateArguments(UpdateMeetingDto updateMeetingDto);

    SearchMeetingArguments toSearchArguments(SearchMeetingDto dto);

}
