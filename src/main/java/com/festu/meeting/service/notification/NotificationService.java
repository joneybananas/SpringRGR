package com.festu.meeting.service.notification;

import com.festu.meeting.model.Notification;
import com.festu.meeting.service.notification.argument.CreateNotificationArgument;
import com.festu.meeting.service.notification.argument.SearchNotificationArgument;
import com.festu.meeting.service.notification.argument.UpdateNotificationArgument;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * Generated by Thanos
 */
public interface NotificationService {

    Notification create(CreateNotificationArgument argument);

    Optional<Notification> get(UUID id);

    Notification getExisting(UUID id);

    List<Notification> list(SearchNotificationArgument argument, Sort sort);

    Page<Notification> page(SearchNotificationArgument argument, Pageable pageable);

    Notification update(UUID id, UpdateNotificationArgument argument);

    void delete(UUID id);
}