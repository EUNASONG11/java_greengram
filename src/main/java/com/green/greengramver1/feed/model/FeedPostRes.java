package com.green.greengramver1.feed.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedPostRes {
    //feed PK값과 파일 이름 여러 개 리턴
    private long feedId;
    private List<String> pics;
}
