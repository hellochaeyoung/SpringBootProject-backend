package com.boot.backend.controller;

import com.boot.backend.dto.MemberDto;
import com.boot.backend.service.MemberService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    MemberService service;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public int register(@RequestBody Map<String, String> map) {

        String id = map.get("id");
        String pwd = map.get("pwd");
        String name = map.get("name");
        String email = map.get("email");

        MemberDto dto = new MemberDto(id, pwd, name, email, 3);

        return service.addMember(dto);
    }

    @RequestMapping(value = "getId", method = RequestMethod.POST)
    public String getId(MemberDto dto) {
        boolean b = service.getId(dto);

        if(b) {
            return "NO";
        }else {
            return "OK";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestBody MemberDto dto) {

        MemberDto result = service.login(dto);

        if(result == null) {
            return "FAIL";
        }else {
            return "SUCCESS";
        }
    }

}
