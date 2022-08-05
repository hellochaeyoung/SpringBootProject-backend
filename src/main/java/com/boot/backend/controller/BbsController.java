package com.boot.backend.controller;

import com.boot.backend.annotation.LoginCheck;
import com.boot.backend.dto.BbsDto;
import com.boot.backend.dto.BbsParam;
import com.boot.backend.dto.ReadCountDto;
import com.boot.backend.service.BbsService;
import com.boot.backend.service.CommentService;
import com.boot.backend.service.ReadCountService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BbsController {

    @Autowired
    BbsService service;

    @Autowired
    CommentService commentService;

    @Autowired
    ReadCountService readCountService;

    Logger logger = LoggerFactory.getLogger(BbsController.class);

    @RequestMapping(value = "getBbs", method = RequestMethod.POST)
    public BbsDto getBbs(int seq) {
        logger.info("BbsController getBbs()");
        return service.getBbs(seq);

    }

    @RequestMapping(value = "addBbs", method = RequestMethod.POST)
    @LoginCheck
    public String addBbs(@RequestBody BbsDto dto) {

        logger.info("BbsController addBbs() " + new Date());

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

        logger.info("BbsController getBbsSearchPageList " + new Date());

        int sn = param.getPageNumber();
        int start = sn * 10 + 1;
        int end = (sn + 1) * 10;

        param.setStart(start);
        param.setEnd(end);

        return service.getBbsSearchPageList(param);
    }

    @RequestMapping(value = "getBbsReactList", method = RequestMethod.GET)
    public Map<String, Object> getBbsReactList(BbsParam param) {
        logger.info("BbsController getBbsReactList " + new Date());

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

        logger.info("BbsController getBbsCount() " + new Date());

        return service.getBbsCount(param);
    }

    @RequestMapping(value = "updateBbs", method = RequestMethod.POST)
    @LoginCheck
    public int updateBbs(@RequestBody BbsDto dto) {
        logger.info("BbsController updateBbs()");

        return service.updateBbs(dto);
    }

    @RequestMapping(value = "deleteBbs", method = RequestMethod.POST)
    @LoginCheck
    public int deleteBbs(int seq) {
        logger.info("BbsController deleteBbs()");

        // 게시물 댓글 삭제
        commentService.deleteComments(seq);

        // 조회수 삭제
        readCountService.deleteReadCount(seq);

        return service.deleteBbs(seq);
    }

    @RequestMapping(value = "checkReadBbs", method = RequestMethod.POST)
    public int checkReadBbs(@RequestBody ReadCountDto dto) {

        //String encounter = "NONE";
        int totalReadCount = service.getBbs(dto.getBbs()).getReadCount();

        String id = dto.getId();
        if( id != null) { // 로그인 했을 때만 처리
            ReadCountDto readCountDto = readCountService.getReadCount(dto);

            if(readCountDto == null) {
                System.out.println("readCountDto is null");
                readCountService.addReadCount(dto);
                service.updateBbsReadCount(dto.getBbs());
                totalReadCount++;
            }
        }

        return totalReadCount;
    }
}
