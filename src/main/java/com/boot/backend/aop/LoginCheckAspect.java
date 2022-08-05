package com.boot.backend.aop;

import com.boot.backend.dto.MemberDto;
import com.boot.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

@Aspect
@RequiredArgsConstructor
public class LoginCheckAspect {

    private final MemberService memberService;

    @Before("@annotation(com.boot.backend.annotation.LoginCheck)")
    public void loginCheck() throws HttpClientErrorException {
        MemberDto member = memberService.getCurrentMember();

        if(member == null) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }
}
