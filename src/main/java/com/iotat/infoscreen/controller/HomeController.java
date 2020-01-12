package com.iotat.infoscreen.controller;

import com.iotat.infoscreen.common.result.ResponseEnum;
import com.iotat.infoscreen.common.result.ResponseJSON;
import com.iotat.infoscreen.entity.Award;
import com.iotat.infoscreen.entity.LabComment;
import com.iotat.infoscreen.entity.Member;
import com.iotat.infoscreen.entity.Project;
import com.iotat.infoscreen.mapper.LabMapper;
import com.iotat.infoscreen.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @Description 首页接口
 * @ClassName HomeController
 * @Author Jean
 * @date 2020.01.12 16:13
 */
@RestController
@Api(tags = "首页接口")
@RequestMapping("/iotat/Lab")
public class HomeController {

    @Autowired
    HomeService homeService;
    @Autowired
    LabMapper labMapper;

    @ApiOperation("获取所有成员")
    @GetMapping("/member")
    public ResponseJSON<ArrayList<Member>> getAllMember() {
        return new ResponseJSON<>(labMapper.selectAllMember(), ResponseEnum.SUCCESS_OPTION);
    }

    @ApiOperation("获取实验室留言板")
    @GetMapping("/comment")
    public ResponseJSON<ArrayList<LabComment>> getAllComment() {
        return new ResponseJSON<>(labMapper.selectAllComment(), ResponseEnum.SUCCESS_OPTION);
    }

    @ApiOperation("获取所有项目")
    @GetMapping("/proj")
    public ResponseJSON<ArrayList<Project>> getAllProj() {
        return new ResponseJSON<>(labMapper.selectAllProj(), ResponseEnum.SUCCESS_OPTION);
    }

    @ApiOperation("获取所有奖项")
    @GetMapping("/award")
    public ResponseJSON<ArrayList<Award>> getAllAward() {
        return new ResponseJSON<>(labMapper.selectAllAward(), ResponseEnum.SUCCESS_OPTION);
    }

    //@Token TODO Token测试留至最后
    @ApiOperation("发表评论")
    @PostMapping("/postComment")
    public ResponseJSON<Boolean> postComment(@RequestBody LabComment comment) {
        return new ResponseJSON<>(homeService.postComment(comment), ResponseEnum.SUCCESS_OPTION);
    }

}
