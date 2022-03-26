package com.festu.meeting.service.vote;

import com.festu.meeting.model.Vote;
import com.festu.meeting.repository.VoteRepository;
import com.festu.meeting.service.vote.arguments.VoteMeetingArguments;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final VoteRepository repository;

    @Transactional
    @Override
    public Vote create(VoteMeetingArguments arguments) {
        validate(arguments);
        return repository.save(Vote.builder()
                                   .meeting(arguments.getMeeting())
                                   .author(arguments.getUser())
                                   .time(arguments.getTime())
                                   .build());
    }

    private void validate(VoteMeetingArguments arguments) {
        boolean hasTime = arguments.getMeeting()
                                   .getAvailableTime().contains(arguments.getTime());

        if (!hasTime) throw new ValidationException("Time is not available");
    }

}
