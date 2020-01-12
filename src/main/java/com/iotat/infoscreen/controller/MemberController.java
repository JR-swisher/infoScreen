package com.iotat.infoscreen.controller;

import com.iotat.infoscreen.common.result.ResponseEnum;
import com.iotat.infoscreen.common.result.ResponseJSON;
import com.iotat.infoscreen.entity.Member;
import com.iotat.infoscreen.entity.StuComment;
import com.iotat.infoscreen.mapper.MemberMapper;
import com.iotat.infoscreen.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * @Description 成员信息接口
 * @ClassName MemberController
 * @Author Jean
 * @date 2020.01.09 21:02
 */
@RestController
@Api(tags = "成员用户接口")
@RequestMapping("/iotat/member")
public class MemberController {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberMapper memberMapper;

    @PostMapping("/register")
    @ApiOperation("成员信息完善")
    public ResponseJSON<Boolean> register(@RequestBody Member member) {
        return new ResponseJSON<>(memberService.register(member), ResponseEnum.REGISTER_SUCCESS);
    }

    //@Token TODO Token测试留至最后
    @ApiOperation("查询单个成员详细信息")
    @GetMapping("/{memberId}")
    public ResponseJSON<Map<String, Object>> getMember(@PathVariable long memberId) {
        return new ResponseJSON<>(memberMapper.selectMemberById(memberId), ResponseEnum.SUCCESS_OPTION);
    }

    //@Token TODO Token测试留至最后
    @ApiOperation("更新成员信息")
    @PutMapping("/updateInfo")
    public ResponseJSON<Boolean> updateMember(@RequestBody Member member) {
        return new ResponseJSON<>(memberService.updateMember(member), ResponseEnum.SUCCESS_OPTION);
    }

    @ApiOperation("获取个人留言板")
    @GetMapping("/comment")
    public ResponseJSON<ArrayList<StuComment>> getAllComment(@RequestParam("Receiver") String receiver) {
        return new ResponseJSON<>(memberMapper.selectCommentByReceiver(receiver), ResponseEnum.SUCCESS_OPTION);
    }

    //@Token TODO Token测试留至最后
    @ApiOperation("发表评论")
    @PostMapping("/postComment")
    public ResponseJSON<Boolean> postComment(@RequestBody StuComment comment) {
        return new ResponseJSON<>(memberService.postComment(comment), ResponseEnum.SUCCESS_OPTION);
    }

}
