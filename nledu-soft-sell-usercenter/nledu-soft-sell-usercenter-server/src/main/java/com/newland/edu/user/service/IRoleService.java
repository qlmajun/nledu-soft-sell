package com.newland.edu.user.service;


import com.newland.edu.common.model.PageResult;
import com.newland.edu.common.model.Result;
import com.newland.edu.common.model.SysRole;
import com.newland.edu.common.service.ISuperService;

import java.util.List;
import java.util.Map;

/***
 * 角色操作服务接口声明
 */
public interface IRoleService extends ISuperService<SysRole> {

    /**
     * 查询所有角色
     *
     * @return
     */
    List<SysRole> findAll();

    /**
     * 角色列表
     *
     * @param params
     * @return
     */
    PageResult<SysRole> findRoles(Map<String, Object> params);

    /**
     * 新增或更新角色
     *
     * @param sysRole
     * @return Result
     */
    Result saveOrUpdateRole(SysRole sysRole) throws Exception;

    /**
     * 新增角色
     *
     * @param sysRole
     * @throws Exception
     */
    void saveRole(SysRole sysRole) throws Exception;

    /**
     * 删除角色
     *
     * @param id
     */
    void deleteRole(Long id);
}
