package com.haocheng.study.service;

import com.haocheng.study.dao.DeptDao;
import com.haocheng.study.model.Dept;
import com.haocheng.study.model.DeptExample;
import com.haocheng.study.util.paging.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: haocheng
 * @Date: 2019-10-12 13:56
 */
@Service
public class DeptService {

    @Resource
    private DeptDao deptDao;


    public List<Dept> getDept(){
        DeptExample example = new DeptExample();
        example.createCriteria();
        return deptDao.getDept(example);
    }

    public List<Dept> get4Page(PageRequest pageRequest) {
        List<Dept> deptList = deptDao.get4Page();
        return deptList;
    }

}
