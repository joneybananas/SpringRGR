package com.festu.rgr.service;

import com.festu.rgr.repository.MeetingRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MetingService {
    MeetingRepository meetingRepository;
}
