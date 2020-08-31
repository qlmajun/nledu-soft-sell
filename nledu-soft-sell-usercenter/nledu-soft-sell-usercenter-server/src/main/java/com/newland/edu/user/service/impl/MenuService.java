package com.newland.edu.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.warrior.central.common.model.SysMenu;
import com.warrior.central.common.service.impl.SuperServiceImpl;
import com.warrior.central.user.mapper.MenuMapper;
import com.warrior.central.user.model.SysRoleMenu;
import com.warrior.central.user.service.IMenuService;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 菜单操作服务接口实现
 *
 * @author majun
 * @date 2020/7/28
 */
@Service
public class MenuService extends SuperServiceImpl<MenuMapper, SysMenu> implements IMenuService {

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public List<SysMenu> findByRoleCodes(Set<String> roleCodes, Integer type) {
        return roleMenuService.findMenusByRoleCodes(roleCodes, type);
    }

    @Override
    public List<SysMenu> getTreeBuildMenu(Set<String> roleCodes, Integer type) {
        List<SysMenu> menus = roleMenuService.findMenusByRoleCodes(roleCodes, type);
        if (CollectionUtils.isEmpty(menus)) {
            return Collections.emptyList();
        }

        List<SysMenu> treeMenus = new ArrayList<>();
        for (SysMenu menu : menus) {
            if (ObjectUtils.equals(-1L, menu.getParentId())) {
                treeMenus.add(menu);
            }
            for (SysMenu sysMenu : menus) {
                if (sysMenu.getParentId().equals(menu.getId())) {
                    if (menu.getSubMenus() == null) {
                        menu.setSubMenus(new ArrayList<>());
                    }
                    menu.getSubMenus().add(sysMenu);
                }
            }
        }
        return treeMenus;
    }

    /**
     * 角色菜单列表
     *
     * @param roleIds
     * @return
     */
    @Override
    public List<SysMenu> findByRoles(Set<Long> roleIds) {
        return roleMenuService.findMenusByRoleIds(roleIds, null);
    }

    /**
     * 查询所有菜单
     */
    @Override
    public List<SysMenu> findAll() {
        return baseMapper.selectList(
                new QueryWrapper<SysMenu>().orderByAsc("sort")
        );
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void setMenuToRole(Long roleId, Set<Long> menuIds) {
        roleMenuService.delete(roleId, null);
        if (!CollectionUtils.isEmpty(menuIds)) {
            List<SysRoleMenu> roleMenus = new ArrayList<>(menuIds.size());
            menuIds.forEach(menuId -> roleMenus.add(new SysRoleMenu(roleId, menuId)));
            roleMenuService.saveBatch(roleMenus);
        }
    }

    /**
     * 查询所有一级菜单
     */
    @Override
    public List<SysMenu> findOnes() {
        return baseMapper.selectList(
                new QueryWrapper<SysMenu>()
                        .eq("type", 1)
                        .orderByAsc("sort")
        );
    }

}
