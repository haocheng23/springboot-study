package com.haocheng.study.service;

import com.haocheng.study.entity.Permissions;

import java.util.List;

/**
 * (Permissions)表服务接口
 *
 * @author makejava
 * @since 2021-01-19 16:31:40
 */
public interface PermissionsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Permissions queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Permissions> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param permissions 实例对象
     * @return 实例对象
     */
    Permissions insert(Permissions permissions);

    /**
     * 修改数据
     *
     * @param permissions 实例对象
     * @return 实例对象
     */
    Permissions update(Permissions permissions);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
