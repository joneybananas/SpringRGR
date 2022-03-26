package com.festu.meeting.repository;

import com.festu.meeting.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
public interface VoteRepository extends JpaRepository<Vote, UUID> {
}
