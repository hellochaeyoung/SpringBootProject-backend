package com.boot.backend.controller;

import com.boot.backend.dto.CommentDto;
import com.boot.backend.service.CommentService;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentService service;

    Logger logger = LoggerFactory.getLogger(CommentController.class);

    @RequestMapping(value = "addComment", method = RequestMethod.POST)
    public int addComment(@RequestBody CommentDto dto) {
        logger.info("CommentController addComment " + new Date());

        return service.addComment(dto);

    }

    @RequestMapping(value = "getCommentList", method = RequestMethod.GET)
    public List<CommentDto> getCommentList(int bbs) {
        logger.info("CommentController getCommentList " + new Date());

        return service.getCommentList(bbs);

    }
}
