package com.haocheng.study.controller;


import com.haocheng.study.model.Dept;
import com.haocheng.study.service.DeptService;
import com.haocheng.study.util.paging.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController {

    @Resource
    private DeptService deptService;


    @GetMapping("/getDept")
    public Dept getDept(){
        return deptService.getDept();
    }

    @PostMapping("/get4Page")
    public List<Dept> get4Page(@RequestBody PageRequest pageRequest){
        return deptService.get4Page(pageRequest);
    }
}
