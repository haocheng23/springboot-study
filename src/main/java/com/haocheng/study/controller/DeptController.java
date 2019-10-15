package com.haocheng.study.controller;


import com.haocheng.study.model.Dept;
import com.haocheng.study.service.DeptService;
import com.haocheng.study.util.paging.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "部门控制")
@RestController
public class DeptController {

    @Resource
    private DeptService deptService;


    @ApiOperation(value = "获取所有部门")
    @GetMapping("/getDept")
    public List<Dept> getDept(){
        return deptService.getDept();
    }

    @ApiOperation(value = "分页获取所有部门")
    @PostMapping("/get4Page")
    public List<Dept> get4Page(@RequestBody PageRequest pageRequest){
        return deptService.get4Page(pageRequest);
    }
}
