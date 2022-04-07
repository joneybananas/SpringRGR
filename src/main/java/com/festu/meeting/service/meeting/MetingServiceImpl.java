package com.festu.meeting.service.meeting;

import com.festu.meeting.exceptions.NotFoundException;
import com.festu.meeting.model.Meeting;


import com.festu.meeting.repository.MeetingRepository;
import com.festu.meeting.service.meeting.arguments.CreateMeetingArguments;
import com.festu.meeting.service.meeting.arguments.SearchMeetingArguments;
import com.festu.meeting.service.meeting.arguments.UpdateMeetingArguments;
import com.festu.meeting.utls.Lists;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MetingServiceImpl implements MeetingService {


    MeetingRepository repository;

    @Override
    @Transactional
    public Meeting create(@NotNull CreateMeetingArguments arguments) {
        return repository.save(Meeting.builder()
                                      .title(arguments.getTitle())
                                      .availableTime(arguments.getAvailableTime())
                                      .author(arguments.getAuthor())
                                      .build());
    }

    @Override
    @Transactional
    public Meeting update(UUID id, UpdateMeetingArguments arguments) {
        Meeting meeting = getExisting(id);

        meeting.setTitle(arguments.getTitle());
        meeting.setAvailableTime(arguments.getAvailableTime());

        return meeting;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Meeting> get(@NotNull UUID id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Meeting getExisting(@NotNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new NotFoundException("Meeting"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Meeting> list(@NonNull SearchMeetingArguments arguments) {

        return Lists.newList(repository.findAll());
    }

    @Override
    public void delete(UUID id) {
        Meeting meeting = getExisting(id);
        repository.delete(meeting);
    }
}
