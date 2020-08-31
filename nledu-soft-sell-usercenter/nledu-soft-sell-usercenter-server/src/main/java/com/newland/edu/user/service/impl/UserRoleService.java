package com.newland.edu.user.service.impl;

import com.warrior.central.common.model.SysRole;
import com.warrior.central.common.service.impl.SuperServiceImpl;
import com.warrior.central.user.mapper.UserRoleMapper;
import com.warrior.central.user.model.SysRoleUser;
import com.warrior.central.user.service.IUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户角色操作服务接口实现
 *
 * @author majun
 * @date 2020/7/27
 */
@Service
public class UserRoleService extends SuperServiceImpl<UserRoleMapper, SysRoleUser> implements IUserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public List<SysRole> findRolesByUserId(Long userId) {
        return userRoleMapper.findRolesByUserId(userId);
    }

    @Override
    public List<SysRole> findRolesByUserIds(List<Long> userIds) {
        return userRoleMapper.findRolesByUserIds(userIds);
    }

    @Override
    public int deleteUserRole(Long userId, Long roleId) {
        return userRoleMapper.deleteUserRole(userId, roleId);
    }
}
