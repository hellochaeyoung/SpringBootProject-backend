package com.boot.backend.controller;

import com.boot.backend.dto.MemberDto;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.boot.backend.service.MemberService;

@RestController // @Controller + @Responsebody -> Restful
public class HelloController {

    @Autowired
    MemberService service;

    @RequestMapping(value = "base", method = RequestMethod.GET)
    public String base() {

        System.out.println("HelloController base() " + new Date());
        return "base";
    }

    @RequestMapping(value = "member", method = RequestMethod.GET)
    public MemberDto getMember() {
        System.out.println("HelloController getMember()" + new Date());

        MemberDto dto = new MemberDto("abc", "123", "홍길동", "abc@naver.com", 3);

        return dto;
    }

    @RequestMapping(value = "conn_param", method = RequestMethod.GET)
    public String conn_param(String title, int num) {

        System.out.println("HelloController conn_param()" + new Date());
        System.out.println("title:" + title);
        System.out.println("num" + num);

        return "conn success";
    }

    @RequestMapping(value = "conn_param_obj", method = RequestMethod.GET)
    public String conn_param_obj(MemberDto dto) {
        System.out.println("HelloController conn_param_obj() " + new Date());

        System.out.println(dto.toString());

        return "OK";
    }

    @RequestMapping(value = "db_test", method = RequestMethod.GET)
    public List<MemberDto> db_test() {
        System.out.println("HelloController db_test() " + new Date());

        List<MemberDto> result = service.allMembers();

        return result;
    }
}
