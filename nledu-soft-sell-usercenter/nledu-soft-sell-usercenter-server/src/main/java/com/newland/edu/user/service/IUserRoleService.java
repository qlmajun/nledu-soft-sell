package com.newland.edu.user.service;


import com.newland.edu.common.model.SysRole;
import com.newland.edu.common.service.ISuperService;
import com.newland.edu.user.model.SysRoleUser;

import java.util.List;

/**
 * 用户角色操作服务接口声明
 */
public interface IUserRoleService extends ISuperService<SysRoleUser> {

    /**
     * 根据用户id获取角色
     *
     * @param userId
     * @return
     */
    List<SysRole> findRolesByUserId(Long userId);

    /**
     * 根据用户ids 获取
     *
     * @param userIds
     * @return
     */
    List<SysRole> findRolesByUserIds(List<Long> userIds);

    /**
     * 删除用户角色
     *
     * @param userId 用户Id
     * @param roleId 角色Id
     * @return
     */
    int deleteUserRole(Long userId, Long roleId);
}
