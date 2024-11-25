package com.green.greengramver1.feed.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedGetRes {
    private long feedId;
    private String contents;
    private String location;
    private String createdAt;
    private long writerId;
    private String writerPic;
    private String writerNm;
}
