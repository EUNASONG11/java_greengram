package com.green.greengramver1.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserSignUpReq {
    @Schema(description = "유저 아이디", example = "mic", requiredMode = Schema.RequiredMode.REQUIRED)
    private String uid;
    @Schema(description = "유저 비밀번호", example = "1212", requiredMode = Schema.RequiredMode.REQUIRED)
    private String upw;
    //@Schema(description = "유저 프로필 사진")
    @JsonIgnore
    private String pic;
    @Schema(description = "유저 닉네임", example = "홍길동")
    private String nickName;
    @JsonIgnore
    private long userId;
}
