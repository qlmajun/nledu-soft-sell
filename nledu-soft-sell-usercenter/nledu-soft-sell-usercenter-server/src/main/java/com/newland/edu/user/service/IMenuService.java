package com.newland.edu.user.service;


import com.newland.edu.common.model.SysMenu;
import com.newland.edu.common.service.ISuperService;

import java.util.List;
import java.util.Set;

/**
 * 菜单操作服务接口声明
 */
public interface IMenuService extends ISuperService<SysMenu> {

    /**
     * 角色菜单列表
     *
     * @param roleCodes 角色编码
     * @param type      类型
     * @return
     */
    List<SysMenu> findByRoleCodes(Set<String> roleCodes, Integer type);

    /**
     * 获取树型角色菜单列表
     *
     * @param roleCodes 角色编码
     * @param type      类型
     * @return
     */
    List<SysMenu> getTreeBuildMenu(Set<String> roleCodes, Integer type);

    /**
     * 角色菜单列表
     *
     * @param roleIds 角色ids
     * @return
     */
    List<SysMenu> findByRoles(Set<Long> roleIds);

    /**
     * 查询所有菜单
     */
    List<SysMenu> findAll();

    /**
     * 角色分配菜单
     * @param roleId
     * @param menuIds
     */
    void setMenuToRole(Long roleId, Set<Long> menuIds);

    /**
     * 查询所有一级菜单
     */
    List<SysMenu> findOnes();
}
