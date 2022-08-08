package com.boot.backend.controller;

import com.boot.backend.dto.MemberDto;
import com.boot.backend.service.MemberService;
import java.util.Date;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    MemberService service;

    Logger logger = LoggerFactory.getLogger(MemberController.class);

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public int register(@RequestBody MemberDto dto) {

        logger.info("MemberController register() " + new Date());

        return service.addMember(dto);
    }

    @RequestMapping(value = "getId", method = RequestMethod.POST)
    public String getId(MemberDto dto) {

        logger.info("MemberController getId() " + new Date());

        boolean b = service.getId(dto);

        if(b) {
            return "NO";
        }else {
            return "OK";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestBody MemberDto dto) {

        logger.info("MemberController login() " + new Date());

        MemberDto result = service.login(dto);

        if(result == null) {
            System.out.println("로그인 실패");
            return "FAIL";
        }

        return result.getId();
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public int logout() {

        logger.info("MemberController logout() " + new Date());

        service.logout();

        return 1;
    }

}
