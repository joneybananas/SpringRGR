package com.festu.rgr.api.meeting;

import com.festu.rgr.service.MetingService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("meeting")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MeetingController {

    MetingService metingService;

    public void list() {

    }

    public void get() {
    }


    @PostMapping
    public void create() {

    }

    @PutMapping
    public void update() {

    }

    @DeleteMapping
    public void delete() {

    }
}
