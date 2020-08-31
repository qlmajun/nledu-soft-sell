package com.newland.edu.user.service.impl;

import com.warrior.central.common.model.SysMenu;
import com.warrior.central.common.service.impl.SuperServiceImpl;
import com.warrior.central.user.mapper.RoleMenuMapper;
import com.warrior.central.user.model.SysRoleMenu;
import com.warrior.central.user.service.IRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author majun
 * @description
 * @date 2020/7/28
 */
@Service
public class RoleMenuService extends SuperServiceImpl<RoleMenuMapper, SysRoleMenu> implements IRoleMenuService {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<SysMenu> findMenusByRoleCodes(Set<String> roleCodes, Integer type) {
        return roleMenuMapper.findMenusByRoleCodes(roleCodes, type);
    }

    @Override
    public List<SysMenu> findMenusByRoleIds(Set<Long> roleIds, Integer type) {
        return roleMenuMapper.findMenusByRoleIds(roleIds, type);
    }

    @Override
    public int delete(Long roleId, Long menuId) {
        return roleMenuMapper.delete(roleId, menuId);
    }
}
