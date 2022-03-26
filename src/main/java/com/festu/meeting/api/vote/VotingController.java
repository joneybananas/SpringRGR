package com.festu.meeting.api.vote;

import com.festu.lib.dto.SimpleObjectValue;
import com.festu.meeting.actions.VoteMeetingAction;
import com.festu.meeting.service.vote.VoteService;
import com.festu.meeting.service.vote.arguments.VoteMeetingArguments;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@RestController
@RequestMapping("meeting")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VotingController {
    VoteMeetingAction meetingAction;
    VoteService voteService;

    @PostMapping("vote/{id}")
    public void vote(@PathVariable UUID id, @RequestBody @Valid SimpleObjectValue<String> dateTime) {
        VoteMeetingArguments vote = meetingAction.execute(id, dateTime);
        voteService.create(vote);
    }
}
