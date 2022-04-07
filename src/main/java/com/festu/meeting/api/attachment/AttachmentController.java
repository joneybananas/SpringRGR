package com.festu.meeting.api.attachment;

import com.festu.meeting.api.attachment.dto.*;
import com.festu.meeting.api.attachment.mapper.AttachmentMapper;
import com.festu.meeting.model.Attachment;
import com.festu.meeting.service.attachment.AttachmentService;
import com.festu.meeting.service.attachment.argument.SearchAttachmentArgument;
import com.festu.meeting.service.attachment.argument.UpdateAttachmentArgument;
import com.festu.meeting.utls.CollectionDto;

import com.festu.meeting.utls.MapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;


/**
 * Generated by Thanos
 */
@RestController
@RequestMapping("attachment")
@RequiredArgsConstructor
public class AttachmentController {

    private final AttachmentService service;
    private final AttachmentMapper mapper;

    @PostMapping("create")
    @ResponseStatus(CREATED)
    public AttachmentDto create(@RequestBody @Valid CreateAttachmentDto dto) {
        return MapperUtils.getMapper(mapper::toDto)
                          .compose(service::create)
                          .compose(mapper::toCreateArgument)
                          .apply(dto);
    }

    @GetMapping("{id}")
    public AttachmentDto get(@PathVariable UUID id) {
        return MapperUtils.getMapper(mapper::toDto)
                          .compose(service::getExisting)
                          .apply(id);
    }

    @GetMapping("list")
    public List<AttachmentListDto> list(SearchAttachmentDto dto, Sort sort) {
        SearchAttachmentArgument argument = mapper.toSearchArgument(dto);

        List<Attachment> list = service.list(argument, sort);

        return MapperUtils.mapList(mapper::toListDto, list);
    }

    @GetMapping("page")
    public CollectionDto<AttachmentListDto> page(SearchAttachmentDto dto, Pageable pageable) {
        SearchAttachmentArgument argument = mapper.toSearchArgument(dto);

        Page<Attachment> page = service.page(argument, pageable);

        return MapperUtils.mapPage(mapper::toListDto, page);
    }

    @PostMapping("{id}/update")
    public AttachmentDto update(@PathVariable UUID id, @RequestBody @Valid UpdateAttachmentDto dto) {
        UpdateAttachmentArgument argument = mapper.toUpdateArgument(dto);

        Attachment entity = service.update(id, argument);

        return mapper.toDto(entity);
    }

    @PostMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}