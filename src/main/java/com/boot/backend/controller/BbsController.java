package com.boot.backend.controller;

import com.boot.backend.dto.BbsDto;
import com.boot.backend.service.BbsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BbsController {

    @Autowired
    BbsService service;

    @RequestMapping(value = "getBbs", method = RequestMethod.GET)
    public List<BbsDto> getBbs() {

        return service.getBbs();

    }
}
