package com.haocheng.study.service.impl;

import com.haocheng.study.dao.PermissionsDao;
import com.haocheng.study.entity.Permissions;
import com.haocheng.study.service.PermissionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Permissions)表服务实现类
 *
 * @author makejava
 * @since 2021-01-19 16:31:40
 */
@Service("permissionsService")
public class PermissionsServiceImpl implements PermissionsService {
    @Resource
    private PermissionsDao permissionsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Permissions queryById(String id) {
        return this.permissionsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Permissions> queryAllByLimit(int offset, int limit) {
        return this.permissionsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param permissions 实例对象
     * @return 实例对象
     */
    @Override
    public Permissions insert(Permissions permissions) {
        this.permissionsDao.insert(permissions);
        return permissions;
    }

    /**
     * 修改数据
     *
     * @param permissions 实例对象
     * @return 实例对象
     */
    @Override
    public Permissions update(Permissions permissions) {
        this.permissionsDao.update(permissions);
        return this.queryById(permissions.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.permissionsDao.deleteById(id) > 0;
    }
}
