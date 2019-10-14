package com.haocheng.study.mapper;

import com.haocheng.study.model.Dept;
import com.haocheng.study.model.DeptExample;
import java.util.List;

public interface DeptMapper {
    long countByExample(DeptExample example);

    int deleteByExample(DeptExample example);

    int insert(Dept record);

    int insertSelective(Dept record);

    List<Dept> selectByExample(DeptExample example);

    /**
     * 分页查询
     * @return
     */
    List<Dept> get4Page();
}