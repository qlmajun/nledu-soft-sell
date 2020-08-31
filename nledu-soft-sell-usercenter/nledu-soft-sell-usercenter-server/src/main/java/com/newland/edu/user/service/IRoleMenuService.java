package com.newland.edu.user.service;


import com.newland.edu.common.model.SysMenu;
import com.newland.edu.common.service.ISuperService;
import com.newland.edu.user.model.SysRoleMenu;

import java.util.List;
import java.util.Set;

/**
 * 角色菜单操作服务接口声明
 */
public interface IRoleMenuService extends ISuperService<SysRoleMenu> {

    /**
     * 根据角色编码和类型获取菜单项
     *
     * @param roleCodes 角色编码
     * @param type      类型
     * @return
     */
    List<SysMenu> findMenusByRoleCodes(Set<String> roleCodes, Integer type);

    /**
     * 根据角色Id和类型获取菜单项
     *
     * @param roleIds 角色Id
     * @param type    类型
     * @return
     */
    List<SysMenu> findMenusByRoleIds(Set<Long> roleIds, Integer type);

    /**
     * 删除角色菜单
     *
     * @param roleId 角色Id
     * @param menuId 菜单Id
     * @return
     */
    int delete(Long roleId, Long menuId);
}
