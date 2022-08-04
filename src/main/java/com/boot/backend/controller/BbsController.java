package com.boot.backend.controller;

import com.boot.backend.dto.BbsDto;
import com.boot.backend.dto.BbsParam;
import com.boot.backend.service.BbsService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @RequestMapping(value = "getBbs", method = RequestMethod.POST)
    public BbsDto getBbs(int seq) {
        System.out.println("BbsController getBbs()");
        return service.getBbs(seq);

    }

    @RequestMapping(value = "addBbs", method = RequestMethod.POST)
    public String addBbs(@RequestBody BbsDto dto) {

        System.out.println("BbsController addBbs() " + new Date());

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

    @RequestMapping(value = "getBbsReactList", method = RequestMethod.GET)
    public Map<String, Object> getBbsReactList(BbsParam param) {
        System.out.println("BbsController getBbsReactList " + new Date());

        int sn = param.getPageNumber();
        int start = sn * 10 + 1;
        int end = (sn + 1) * 10;

        param.setStart(start);
        param.setEnd(end);

        List<BbsDto> list = service.getBbsSearchPageList(param);
        int count = service.getBbsCount(param);

        Map<String, Object> map = new HashMap<>();
        map.put("bbslist", list);
        map.put("cnt", count);

        return map;
    }

    @RequestMapping(value = "getBbsCount", method = RequestMethod.GET)
    public int getBbsCount(BbsParam param) {
        return service.getBbsCount(param);
    }

    @RequestMapping(value = "updateBbs", method = RequestMethod.POST)
    public int updateBbs(@RequestBody BbsDto dto) {
        System.out.println("BbsController updateBbs()");
        return service.updateBbs(dto);
    }
}
