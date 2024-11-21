package com.green.greengramver1.user;

import com.green.greengramver1.common.model.ResultResponse;
import com.green.greengramver1.user.model.UserSignInReq;
import com.green.greengramver1.user.model.UserSignInRes;
import com.green.greengramver1.user.model.UserSignUpReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@Tag(name="1. 유저", description = "회원가입, 로그인 처리")
public class UserController {
    private final UserService service;

    /*
        파일(MultipartFile) + Data
        파일 업로드시에는 @RequestBody를 사용할 수 없다.
        @RequestPart애노테이션을 사용해야 한다.
     */

    //pic != null ? pic.getOriginalFilename() : null >> null일 경우 에러가 터지기 때문에 null이 아니었을 때만 메소드 호출
    @PostMapping("sign-up")
    @Operation(summary = "회원가입")
    public ResultResponse<Integer> signUp(@RequestPart UserSignUpReq p, @RequestPart(required = false) MultipartFile pic) {
        log.info("UserInsReq: {}, file: {}", p, pic != null ? pic.getOriginalFilename() : null);
        int result = service.postSignUp(pic, p);
        return ResultResponse.<Integer>builder()
                .resultMessage("회원가입 완료")
                .resultData(result)
                .build();
    }

    @PostMapping("sign-in")
    @Operation(summary = "로그인")
    public ResultResponse<UserSignInRes> signIn(@RequestBody UserSignInReq p) {
        UserSignInRes res = service.postSignIn(p);
        return ResultResponse.<UserSignInRes>builder()
                .resultMessage(res.getMessage())
                .resultData(res)
                .build();
    }
}
