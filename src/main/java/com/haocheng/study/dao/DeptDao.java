package com.haocheng.study.dao;

import com.haocheng.study.mapper.DeptMapper;
import com.haocheng.study.model.Dept;
import com.haocheng.study.model.DeptExample;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class DeptDao {
    @Resource
    private DeptMapper mapper;

    public Dept getDept(DeptExample example){
        List<Dept> depts = mapper.selectByExample(example);
        return depts.get(0);
    }

    public List<Dept> get4Page() {
        return mapper.get4Page();
    }
}
