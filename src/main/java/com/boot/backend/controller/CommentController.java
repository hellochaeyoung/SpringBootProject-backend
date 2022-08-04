package com.boot.backend.controller;

import com.boot.backend.dto.CommentDto;
import com.boot.backend.service.CommentService;
import java.util.Date;
import java.util.List;
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

    @RequestMapping(value = "addComment", method = RequestMethod.POST)
    public int addComment(@RequestBody CommentDto dto) {
        System.out.println("CommentController addComment " + new Date());

        return service.addComment(dto);

    }

    @RequestMapping(value = "getCommentList", method = RequestMethod.GET)
    public List<CommentDto> getCommentList(int bbs) {
        System.out.println("CommentController getCommentList " + new Date());

        return service.getCommentList(bbs);

    }
}
