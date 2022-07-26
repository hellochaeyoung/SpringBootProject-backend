package com.boot.backend.controller;

import com.boot.backend.dto.BbsDto;
import com.boot.backend.dto.BbsParam;
import com.boot.backend.service.BbsService;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BbsController {

    @Autowired
    BbsService service;

    Logger logger = LoggerFactory.getLogger(BbsController.class);

    @RequestMapping(value = "getBbs", method = RequestMethod.GET)
    public List<BbsDto> getBbs() {
        return service.getBbs();

    }

    @RequestMapping(value = "addBbs", method = RequestMethod.GET)
    public String addBbs(BbsDto dto) {
        boolean b = service.addBbs(dto);

        if(b) return "OK";

        return "NO";
    }

    @RequestMapping(value = "getBbsByKeyword", method = RequestMethod.GET)
    public List<BbsDto> getBbsByKeyword(BbsParam param) {

        logger.info("BbsController getBbsByKeyword() " + new Date());
        List<BbsDto> list = service.getBbsByKeyword(param);

        return list;
    }

    @RequestMapping(value = "getBbsSearchPageList", method = RequestMethod.GET)
    public List<BbsDto> getBbsSearchPageList(BbsParam param) {

        int sn = param.getPageNumber();
        int start = sn * 10 + 1;
        int end = (sn + 1) * 10;

        param.setStart(start);
        param.setEnd(end);

        return service.getBbsSearchPageList(param);
    }

    @RequestMapping(value = "getBbsCount", method = RequestMethod.GET)
    public int getBbsCount(BbsParam param) {
        return service.getBbsCount(param);
    }

}
