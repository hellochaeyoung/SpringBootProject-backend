package com.boot.backend.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ReadCountDto {

    private int seq;

    private int bbs;

    private String id;


}
