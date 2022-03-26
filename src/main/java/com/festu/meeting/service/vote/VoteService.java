package com.festu.meeting.service.vote;

import com.festu.meeting.model.Vote;
import com.festu.meeting.service.vote.arguments.VoteMeetingArguments;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
public interface VoteService {

    Vote create(VoteMeetingArguments arguments);

}
